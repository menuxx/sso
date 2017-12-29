package com.yingtaohuo.routes.pc

import com.google.common.io.Files
import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBShop
import com.yingtaohuo.db.DBTable
import com.yingtaohuo.db.TableStatusOfDisable
import com.yingtaohuo.db.fromRecord
import com.yingtaohuo.exception.NotFoundException
import com.yingtaohuo.exception.WXAccessTokenException
import com.yingtaohuo.exception.WXHttpException
import com.yingtaohuo.model.TableModel
import com.yingtaohuo.props.AppProps
import com.yingtaohuo.resp.RespData
import com.yingtaohuo.service.QiniuService
import com.yingtaohuo.sso.db.tables.records.TCorpRecord
import com.yingtaohuo.util.*
import com.yingtaohuo.wx.QrCodeInfo
import com.yingtaohuo.wx.WXAuthorizerCache
import com.yingtaohuo.wx.WXLiteApi
import okhttp3.OkHttpClient
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.core.io.ClassPathResource
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.io.ByteArrayInputStream
import java.io.File
import java.util.*
import javax.validation.Valid

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/26
 * 微信: yin80871901
 */
@AllOpen
@Controller
@RequestMapping("/tables")
@PreAuthorize("hasRole('ADMIN')")
class TableRoute (
        val appProps: AppProps,
        val dbShop: DBShop,
        val wxAuthorizerCache: WXAuthorizerCache,
        val dbTable: DBTable,
        val qiniuService: QiniuService,
        val wxLiteApi: WXLiteApi,
        val commonHttpClient: OkHttpClient
) {

    @GetMapping("/list")
    fun tableListView(model: Model) : String {
        val user = getCurrentUser()
        val tables = dbTable.getTablesRangeOfShop(user.shopId)
        val shop = dbShop.getShopById(user.shopId)
        model.addAttribute("shop", shop)
        model.addAttribute("user", user)
        model.addAttribute("title", "桌子")
        model.addAttribute("tables", tables)
        return "pc/table_list"
    }

    @GetMapping("/")
    @ResponseBody
    fun getTableList(model: Model) : RespData<List<TableModel>> {
        val user = getCurrentUser()
        val tables : List<TableModel> = dbTable.getTablesRangeOfShop(user.shopId).map(::fromRecord)
        return RespData(tables).success()
    }

    data class NewTable(@NotEmpty val tableName: String)
    @PostMapping("/")
    @ResponseBody
    fun newTable(@RequestBody table: NewTable) : TableModel {
        val model = TableModel()
        val user = getCurrentUser()
        model.corpId = user.shopId
        model.tableName = table.tableName
        return fromRecord(dbTable.insertTableToShop(tableModel = model, shopId = user.shopId))
    }

    @PutMapping("/{tableId}")
    @ResponseBody
    fun delTable(@PathVariable tableId: Int) : RespData<Int> {
        return RespData(dbTable.updateTableStatus(tableId, TableStatusOfDisable)).success()
    }

    fun createAndUploadNewQrCodeImage(accessToken: String, logoData: ByteArray, path: String) : Map<String, String> {
        val resp = wxLiteApi.createWXQrcode(accessToken, QrCodeInfo(path, 430))
        val body = resp.body()
        if ( resp.isSuccessful && body != null ) {
            val filename = UUID.randomUUID().toString()
            val bytes = body.bytes()
            Files.write(bytes, File("$filename.jpg"))
            // 读取为微信生成的二维码
            val qrcodeData = parseQrcode(File("$filename.jpg"))
            // 重新生成带 logo 的二维码
            val bottomImg = getUrlImageToByteArray(commonHttpClient, appProps.siteUrl + "/qrcode-bottom.png")
            val newQrcodeImage = get2CodeImage(qrcodeData, logoData, bottomImg!!)
            // 上传新做成的文件
            val fileKey = qiniuService.uploadFile(ByteArrayInputStream(newQrcodeImage.toByteArray()), "images/table/$filename.png")
            return mapOf("qrCodeData" to qrcodeData, "fileKey" to fileKey)
        } else {
            throw WXHttpException(resp.message())
        }
    }

    fun createAndUploadImage(accessToken: String, path: String) : Map<String, String> {
        val resp = wxLiteApi.createWXQrcode(accessToken, QrCodeInfo(path, 430))
        val body = resp.body()
        if ( resp.isSuccessful && body != null ) {
            val filename = UUID.randomUUID().toString()
            val bytes = body.bytes()
            Files.write(bytes, File("$filename.jpg"))
            // 读取为微信生成的二维码
            val qrCodeData = parseQrcode(File("$filename.jpg"))
            val i = ByteArrayInputStream(bytes.copyOf())
            val fileKey = qiniuService.uploadFile(i, "images/table/$filename.jpg")
            return mapOf("qrCodeData" to qrCodeData, "fileKey" to fileKey)
        } else {
            throw WXHttpException(resp.message())
        }
    }

    fun getLogoData(shop: TCorpRecord) : ByteArray {
        val logoData = getUrlImageToByteArray(commonHttpClient, "https://file.menuxx.com/images/corps/logo/" + shop.logoPath + "?imageView2/2/w/100/h/100")
        if ( logoData == null ) {
            throw NotFoundException("shop ${shop.id}-${shop.shopName} logo not found")
        }
        return logoData
    }

    fun updateTableQrCode(tableId: Int, pagePath: String, data: Map<String, String>) : Map<String, String> {
        dbTable.updateTable(tableId,
                qrCodeUrl = data["fileKey"]!!,
                qrCodeData = data["qrCodeData"]!!,
                qrCodePagePath = pagePath
        )
        return mapOf("fileKey" to data["fileKey"]!!)
    }

    data class TableCode(@NotEmpty val tableId: Int, @NotEmpty val codeType: Int)
    @PutMapping("/createwxqrcode")
    @ResponseBody
    fun genTableQrcode(@Valid @RequestBody tableCode: TableCode) : RespData<Map<String, String>> {
        val shopId = getCurrentUser().shopId
        val shop = dbShop.getShopById(shopId)
        val table = dbTable.getTableById(tableCode.tableId)
        if ( table != null ) {
            when (tableCode.codeType) {
            // 1. 店铺码
            // 2. 桌码
            // 3. 付款码
            // 4. 平台码
                1 -> {
                    // corpType 0 单店版
                    // corpType 1 多店版
                    val accessToken = wxAuthorizerCache.getAuthorizerToken(shop.authorizerAppid)
                    if ( accessToken != null ) {
                        val pagePath = "/pages/index/index?corpId=${shop.id}"
                        return RespData(updateTableQrCode(tableCode.tableId, pagePath, createAndUploadNewQrCodeImage(accessToken, getLogoData(shop), pagePath))).success()
                    } else {
                        throw WXAccessTokenException("accessToken not found")
                    }
                }
            // 桌码
                2 -> {
                    // corpType 0 单店版
                    // corpType 1 多店版
                    when ( shop.corpType ) {
                        0 -> {
                            val accessToken = wxAuthorizerCache.getAuthorizerToken(shop.authorizerAppid)
                            if ( accessToken != null ) {
                                val pagePath = "/pages/index/index?corpId=${shop.id}&tableId=${table.id}"
                                return RespData(updateTableQrCode(
                                        table.id,
                                        pagePath,
                                        createAndUploadImage(accessToken, pagePath)
                                )).success()
                            } else {
                                throw WXAccessTokenException("accessToken not found")
                            }
                        }
                        1 -> {
                            // 多店版 authorizerAppid 就是，父店铺的 authorizerAppid
                            val pShop = dbShop.getShopById(shop.platformId)
                            val accessToken = wxAuthorizerCache.getAuthorizerToken(pShop.authorizerAppid)
                            if ( accessToken != null ) {
                                val pagePath = "/pages/index/index?corpId=$shopId&tableId=${table.id}"
                                return RespData(updateTableQrCode(
                                        table.id,
                                        pagePath,
                                        createAndUploadNewQrCodeImage(accessToken, getLogoData(shop), pagePath)
                                )).success()
                            } else {
                                throw WXAccessTokenException("accessToken not found")
                            }
                        }
                        else -> {
                            return RespData(null).failed("not support table type of ${tableCode.codeType}", 102)
                        }
                    }
                }
            // 付款码
                3 -> {
                    val accessToken = wxAuthorizerCache.getAuthorizerToken(shop.authorizerAppid)
                    if ( accessToken != null ) {
                        val pagePath = "/pages/payment/payment?corpId=${shop.id}"
                        return RespData(updateTableQrCode(
                                table.id,
                                pagePath,
                                createAndUploadNewQrCodeImage(accessToken, getLogoData(shop), pagePath)
                        )).success()
                    } else {
                        throw WXAccessTokenException("accessToken not found")
                    }
                }
                4 -> {
                    // 多店版 authorizerAppid 就是，父店铺的 authorizerAppid
                    val pShop = dbShop.getShopById(shop.platformId)
                    val accessToken = wxAuthorizerCache.getAuthorizerToken(pShop.authorizerAppid)
                    if ( accessToken != null ) {
                        val pagePath = "/pages/shops/shops"
                        return RespData(updateTableQrCode(
                                table.id,
                                pagePath,
                                createAndUploadImage(accessToken, pagePath)
                        )).success()
                    } else {
                        throw WXAccessTokenException("accessToken not found")
                    }
                }
                else -> {
                    return RespData(null).failed("not support table type of ${tableCode.codeType}", 102)
                }
            }
        } else {
            throw NotFoundException("table not found")
        }
    }

}