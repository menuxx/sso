package com.yingtaohuo.wx

import com.fasterxml.jackson.databind.ObjectMapper
import com.yingtaohuo.props.WeixinProps
import com.yingtaohuo.wechat.WXApiCachedClient
import com.yingtaohuo.wechat.WXCommonApi
import com.yingtaohuo.wechat.WXUserApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/16
 * 微信: yin80871901
 */
@Configuration
class WXConfig(val objectMapper: ObjectMapper, wxProps: WeixinProps) {

    private val apiClient = WXApiCachedClient(wxProps.serviceNo.appId, wxProps.serviceNo.appSecret)

    @Bean
    fun wxListApi() : WXLiteApi {
        return WXLiteApi(objectMapper)
    }

    @Bean
    fun wxUserApi() : WXUserApi {
        return apiClient.getUserClient()
    }

    @Bean
    fun wxCommonApi() : WXCommonApi {
        return apiClient.getCommonClient()
    }

}