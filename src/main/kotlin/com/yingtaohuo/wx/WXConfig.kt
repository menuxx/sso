package com.yingtaohuo.wx

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/16
 * 微信: yin80871901
 */
@Configuration
class WXConfig(val objectMapper: ObjectMapper) {

    @Bean
    fun wxListApi() : WXLiteApi {
        return WXLiteApi(objectMapper)
    }

}