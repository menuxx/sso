package com.yingtaohuo

import com.yingtaohuo.HexUtil.bytesToHexString
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import org.slf4j.LoggerFactory
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/15
 * 微信: yin80871901
 */

val ClientWorkModelOfDebug = "1"
val ClientWorkModelOfProd = "0"

class FeieSignature(val user: String, val ukey: String) {

    val stime: String = (System.currentTimeMillis() / 1000).toString()

    private fun hexSha1(str: String) : String {
        val sha1 = MessageDigest.getInstance("SHA1")
        return bytesToHexString(sha1.digest(str.toByteArray()))
    }

    fun genSign() : String {
        return hexSha1(user + ukey + stime)
    }

}

data class Header(
        val user: String,
        val stime: String,
        val sig: String,
        val apiname: String,
        val debug: String
)

open class FeieClient(private val user: String, private val ukey: String) {

    private val ApiUrl = "http://api.feieyun.cn/Api/Open/"

    private val logger = LoggerFactory.getLogger(FeieClient::class.java)

    private val httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor { msg -> println("FEIE " + msg) }.setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(4, TimeUnit.SECONDS)
            .build()

    private fun getHeader(apiname: String): Header {
        val sign = FeieSignature(user, ukey)
        println(sign.genSign())
        return Header(
                user = user,
                debug = ClientWorkModelOfProd,
                stime = sign.stime,
                sig = sign.genSign(),
                apiname = apiname
        )
    }

    private fun getString(key: String, map: Map<String, String>): String {
        return if (map[key] == null) {
            ""
        } else {
            map[key]!!
        }
    }

    private fun post(header: Header, payload: String) : JSONObject {

        val mediaType = MediaType.parse("application/x-www-form-urlencoded")

        val builder = StringBuffer()

        builder.append("user=").append(header.user).append("&")
                .append("stime=").append(header.stime).append("&")
                .append("sig=").append(header.sig).append("&")
                .append("apiname=").append(header.apiname).append("&")
                .append("debug=").append(header.debug).append("&")
                .append(payload)

        val body = RequestBody.create(mediaType, builder.toString())

        val request = Request.Builder().post(body).url(ApiUrl).build()

        try {

            val resp = httpClient.newCall(request).execute()

            if ( resp.isSuccessful ) {

                val body = resp.body()?.string()

                return JSONObject(body)

            } else {

                throw FeieException("请求出现错误 : " + resp.message())

            }

        } catch (ex: Exception) {

            throw FeieException("请求出现错误", ex)

        }

    }

    /**
     * name: Open_printerAddlist
     *
     * 功能描述：
     * 批量添加打印机，请严格参照格式说明：
     * 批量添加规则：
     * 打印机编号(必填) # 打印机识别码(必填) # 备注名称(选填) # 流量卡号码(选填)，多台打印机请换行（\n）添加新打印机信息，每次最多100行(台)。
     * 每次最多添加100台。
     *
     */
    @Throws(FeieException::class)
    fun printerAddlist(printers: List<Map<String, String>>) : JSONObject {

        val header = getHeader("Open_printerAddlist")

        val builder = StringBuilder()

        builder.append("printerContent").append("=")

        for ( printer in printers ) {
            builder.append(getString("sn", printer)).append(" # ")
                    .append(getString("key", printer)).append(" # ")
                    .append(getString("remark", printer)).append(" # ")
                    .append(getString("sim_card_code", printer)).append(" # ")
                    .append("\n")
        }

        return post(header, builder.toString())

    }

    /**
     * 删除批量打印机，Open_printerDelList
     */
    @Throws(FeieException::class)
    fun printerDelList(snlist: List<String>) : JSONObject {
        val header = getHeader("Open_printerDelList")
        val builder = StringBuilder()
        builder.append("snlist=").append(snlist.joinToString("-"))
        return post(header, builder.toString())
    }

    /**
     * 清空待打印队列, Open_delPrinterSqs
     */
    @Throws(FeieException::class)
    fun delPrinterSqs(sn: String) : JSONObject {
        val header = getHeader("Open_delPrinterSqs")
        val builder = StringBuilder()
        builder.append("sn=").append(sn)
        return post(header, builder.toString())
    }

    /**
     * 修改打印机信息，Open_printerEdit
     * 返回示例：
     * 正确：
     * {
     *  "msg":"ok",
     *  "ret":0,
     *  "data":true,
     *  "serverExecutedTime":9
     * }
     * 错误：
     * {
     *  "msg":"参数错误 : 时间格式不正确。",
     *  "ret":1001,
     *  "data":null,
     *  "serverExecutedTime":37
     * }
     */
    @Throws(FeieException::class)
    fun printerEdit(sn: String, name: String?, phonenum: String?) : JSONObject {
        val header = getHeader("Open_printerEdit")
        val builder = StringBuilder()
        builder.append("sn=").append(sn)
        if (name != null) {
            builder.append('&').append("name=").append(name)
        }
        if (phonenum != null) {
            builder.append("&").append("phonenum=").append(phonenum)
        }
        return post(header, builder.toString())
    }

    /**
     * 查询订单是否打印成功，Open_queryOrderState
     * 根据订单ID,去查询订单是否打印成功,订单ID由接口Open_printMsg返回
     * 返回示例：
     * 正确：
     * {
     *  "msg":"ok",
     *  "ret":0,
     *  "data":true,
     *  "serverExecutedTime":2
     * }
     * 错误：
     * {
     *  "msg":"参数错误 : 该帐号未注册.",
     *  "ret":-2,
     *  "data":null,
     *  "serverExecutedTime":37
     * }
     */
    @Throws(FeieException::class)
    fun queryOrderState(orderId: String) : JSONObject {
        val header = getHeader("Open_queryOrderState")
        val builder = StringBuilder()
        builder.append("orderid=").append(orderId)
        return post(header, builder.toString())
    }

    /**
     * 打印订单，Open_printMsg
     * 返回示例：
     * 正确：
     * {
     *  "msg":"ok",
     *  "ret":0,
     *  "data":"816501678_20160919184316_1419533539",
     *  "serverExecutedTime":3
     * }
     * 错误：
     * {
     *  "msg":"参数错误 : 该帐号未注册.",
     *  "ret":-2,
     *  "data":null,
     *  "serverExecutedTime":37
     * }
     */
    @Throws(FeieException::class)
    fun printMsg(sn: String, content: String, times: Int?) : JSONObject {
        val header = getHeader("Open_printMsg")
        val builder = StringBuilder()
        builder.append("sn=").append(sn)
                .append("&").append("content=").append(content)
        if ( times != null ) {
            builder.append("&").append("times=").append(times)
        }
        return post(header, builder.toString())
    }

    /**
     * 获取某台打印机状态，Open_queryPrinterStatus
     * 返回示例：
     * 正确：
     * {
     *  "msg":"ok",
     *  "ret":0,
     *  "data":"在线，工作状态正常",
     *  "serverExecutedTime":9
     * }
     * 错误：
     * {
     *  "msg":"参数错误 : 时间格式不正确。",
     *  "ret":1001,
     *  "data":null,
     *  "serverExecutedTime":37
     * }
     * 返回打印机状态信息。共三种：
     * 1、离线
     * 2、在线，工作状态正常
     * 3、在线，工作状态不正常。
     * 备注：异常一般是无纸，离线的判断是打印机与服务器失去联系超过5分钟。
     */
    @Throws(FeieException::class)
    fun queryPrinterStatus(sn: String) : JSONObject {
        val header = getHeader("Open_queryPrinterStatus")
        val builder = StringBuilder()
        builder.append("sn=").append(sn)
        return post(header, builder.toString())
    }

    /**
     * 查询指定打印机某天的订单统计数，Open_queryOrderInfoByDate
     * sn	必须	string	打印机编号
     * date	必须	string	查询日期，格式YY-MM-DD，如：2016-09-20
     * 返回示例：
     * 正确：
     * {
     *  "msg":"ok",
     *  "ret":0,
     *  "data":{"print":6,"waiting":1},
     *  "serverExecutedTime":9
     * }
     * 错误：
     * {
     *  "msg":"参数错误 : 时间格式不正确。",
     *  "ret":1001,
     *  "data":null,
     *  "serverExecutedTime": 37
     * }
     */
    @Throws(FeieException::class)
    fun queryOrderInfoByDate(sn: String, date: Date) : JSONObject {
        val format = SimpleDateFormat("YY-MM-DD")
        val header = getHeader("Open_queryOrderInfoByDate")
        val builder = StringBuilder()
        builder.append("sn=").append(sn).append("&").append("date=").append(format.format(date))
        return post(header, builder.toString())
    }

    @Throws(FeieException::class)
    fun printTestTicket(sn: String, times: Int?) : JSONObject {
        val content = """
<CB># 10 堂食 (测试订单)</CB><BR>
<CB>404号桌</CB><BR>
================================<BR>
<L>名称            数量      金额<L>
--------------------------------
<L>蛋炒饭</L><BR>
156213645231747
3213123123
<L>                 2份    ￥32.0</L><BR>
--------------------------------
<L>番茄鸡蛋炒饭</L>
<L>                 3份    ￥65.0</L><BR>
--------------------------------
<L>番茄鸡蛋盖浇饭</L>
<L>                 1份    ￥28.0</L><BR>
--------------------------------
<L>红烧番茄鸡蛋盖浇饭</L>
<L>                 1份    ￥28.0</L><BR>
================================<BR>
合计：￥300.0(已支付)
流水号: 10
票券: 满10元减5元券
订单号：20171102091220918290
时间：1027-11-02 09:12:20
================================<BR>
<QR>https://mp.weixin.qq.com/a/~Zgpd4A0pWy0mpOhSCbtmTA~~</QR><BR>
<C>-----樱桃火乐生活-----</C>
"""
        return printMsg(sn, content, times)
    }
}