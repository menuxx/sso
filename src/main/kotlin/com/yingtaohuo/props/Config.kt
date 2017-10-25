package com.yingtaohuo.props

import com.yingtaohuo.NoArg
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.stereotype.Component

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */
@ConfigurationProperties("qiniu")
@Component
@NoArg
data class QiNiuProps(var bucket: String, var accessKey: String, var secretKey: String)

@ConfigurationProperties("ronglian")
@Component
@NoArg
data class RongLianProps(var appId: String, var accountSid: String, var authToken: String)


@ConfigurationProperties("app")
@Component
@NoArg
data class AppProps(var cdnUrl: String, var siteUrl: String, var ssoSecret: String, var envs: Array<String>)

@ConfigurationProperties("weixin")
@Component
@NoArg
data class WeixinProps(
        @NestedConfigurationProperty
        var subscribeNo: WeixinSubscribeNo,
        @NestedConfigurationProperty
        var serviceNo: WeixinServiceNo
)

@NoArg
data class WeixinSubscribeNo(
        var appId: String,
        var appSecret: String
)

@NoArg
data class WeixinServiceNo(
        var appId: String,
        var appSecret: String
)

