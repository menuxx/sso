package com.yingtaohuo.wx

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/15
 * 微信: yin80871901
 *
 * /pages/index/index?corpId=120 店铺
 * /pages/menu/menu?tableId=1230 桌码
 */

data class QrCodeInfo(val path: String, val width: Int)

class WXLiteApi(private val objectMapper: ObjectMapper) {

    private val logger = LoggerFactory.getLogger(WXLiteApi::class.java)

    private val BaseUrl = "https://api.weixin.qq.com/cgi-bin"

    private val httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor { msg -> logger.debug("WXLiteApi: " + msg) }.setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(4, TimeUnit.SECONDS)
            .build()

    /**
     * https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token={accessToken}
     */
    fun createWXQrcode(accessToken: String, info: QrCodeInfo) : Response {
        val info = objectMapper.writeValueAsString(info)
        val body = RequestBody.create(MediaType.parse("application/json"), info)
        val req = Request.Builder()
                .post(body)
                .url( BaseUrl + "/wxaapp/createwxaqrcode?access_token=$accessToken")
                .build()
        return httpClient.newCall(req).execute()
    }

}