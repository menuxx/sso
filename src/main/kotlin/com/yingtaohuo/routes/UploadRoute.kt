package com.yingtaohuo.routes

import com.qiniu.util.Auth
import com.yingtaohuo.AllOpen
import com.yingtaohuo.props.QiNiuProps
import com.yingtaohuo.resp.RespData
import com.yingtaohuo.util.getCurrentUser
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */
@RestController
@RequestMapping("/upload")
@PreAuthorize("hasRole('ADMIN')")
@AllOpen
class UploadRoute(val qiniuProps: QiNiuProps) {

    /**
     * @example
     * /qiniu_token?key=item/123456789.jpg
     */
    data class UpToken(val expireIn: Int, val uptoken: String)
    @GetMapping("/qiniu_token")
    fun qiniuToken(@RequestParam key: String) : RespData {
        val auth = Auth.create(qiniuProps.accessKey, qiniuProps.secretKey)
        val upToken = auth.uploadToken(qiniuProps.bucket, key)
        return RespData(UpToken(3600, upToken)).success()
    }

}