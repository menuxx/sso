package com.yingtaohuo.props

import com.yingtaohuo.NoArg
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */
@ConfigurationProperties("qiniu")
@Component
@NoArg
data class QiNiuProps(var bucket: String?, var accessKey: String?, var secretKey: String?)

@ConfigurationProperties("app")
@Component
@NoArg
data class AppProps(var cdnUrl: String?, var siteUrl: String?)