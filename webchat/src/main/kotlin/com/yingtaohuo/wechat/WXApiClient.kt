package com.yingtaohuo.wechat

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import feign.Feign
import feign.Response
import feign.ResponseMapper
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.slf4j.LoggerFactory
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.google.common.cache.CacheLoader
import com.google.common.cache.CacheBuilder
import com.google.common.reflect.Reflection
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/17
 * 微信: yin80871901
 */

open class WXApiClient(val appId: String, val appSecret: String) {

    val objectMapper = ObjectMapper()

    private val logger = LoggerFactory.getLogger(WXApiClient::class.java)

    val httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor { msg -> logger.debug("WXApi: " + msg) }.setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(4, TimeUnit.SECONDS)
            .build()!!

    init {
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"))
        objectMapper.dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        objectMapper.registerModule(KotlinModule())
    }

    inline fun <reified Api> build(baseUrl: String) : Api {
        val decoder = JacksonDecoder(objectMapper)
        val encoder = JacksonEncoder(objectMapper)
        return Feign.builder()
                .client(feign.okhttp.OkHttpClient(httpClient))
                .encoder(encoder)
                .decoder(decoder)
                .mapAndDecode(WXResponseMapper(objectMapper), decoder)
                .target(Api::class.java, baseUrl)

    }

    open fun getCommonClient() : WXCommonApi {
        return build("https://api.weixin.qq.com/")
    }

    open fun getUserClient() : WXUserApi {
        return build("https://api.weixin.qq.com/")
    }

}

class WXApiCachedClient(appId: String, appSecret: String) : WXApiClient(appId, appSecret) {

    inner class CachedInvocationHandler(val sourceApi: WXCommonApi, val appId: String, val appSecret: String) : InvocationHandler {

        private val tokenCache = CacheBuilder.newBuilder().concurrencyLevel(4)
                .maximumSize(10)
                .softValues()
                .refreshAfterWrite(7200 - 100, TimeUnit.SECONDS)
                .expireAfterWrite(7200 - 100, TimeUnit.SECONDS)
                .build(object : CacheLoader<String, WXAccessToken>() {
                    @Throws(WXException::class)
                    override fun load(key: String): WXAccessToken {
                        return sourceApi.getAccessToken(appId, appSecret)
                    }
                })

        override fun invoke(proxy: Any, method: Method, args: Array<out Any>): Any {
            if ( method.name == "getAccessToken" && method.returnType.simpleName == "WXAccessToken" ) {
                return tokenCache.get("accessToken")
            }
            return method.invoke(proxy, args)
        }
    }

    override fun getCommonClient(): WXCommonApi {
        val api = super.getCommonClient()
        val handler = CachedInvocationHandler(api, appId, appSecret)
        return Reflection.newProxy(WXCommonApi::class.java, handler)
    }
}

class WXResponseMapper(private val objectMapper: ObjectMapper) : ResponseMapper {
    override fun map(response: Response, type: Type): Response {
        val body = response.body()
        val res = objectMapper.readValue<WXResult>(body.asInputStream())
        if ( res.errcode != 0 ) {
            throw WXException(res.errmsg, res.errcode)
        }
        return response
    }
}