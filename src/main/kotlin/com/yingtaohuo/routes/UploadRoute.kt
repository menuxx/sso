package com.yingtaohuo.routes

import com.qiniu.util.Auth
import com.yingtaohuo.AllOpen
import com.yingtaohuo.props.QiNiuProps
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */
@AllOpen
@RestController
@RequestMapping("/upload")
class UploadRoute(val qiniuProps: QiNiuProps) {

    /**
     * @example
     * /qiniu_token?key=item/123456789.jpg
     */
    data class UpToken(val expireIn: Int, val uptoken: String)
    @GetMapping("/qiniu_token")
    fun qiniuToken() : UpToken {
        val auth = Auth.create(qiniuProps.accessKey, qiniuProps.secretKey)
        val upToken = auth.uploadToken(qiniuProps.bucket)
        return UpToken(3600, upToken)
    }

}