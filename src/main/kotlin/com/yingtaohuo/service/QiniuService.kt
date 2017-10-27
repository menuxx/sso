package com.yingtaohuo.service

import com.qiniu.common.QiniuException
import com.qiniu.storage.Configuration
import com.qiniu.storage.UploadManager
import com.qiniu.util.Auth
import com.yingtaohuo.exception.QiniuUploadException
import com.yingtaohuo.props.QiNiuProps
import okio.Okio
import org.springframework.stereotype.Service
import java.io.InputStream

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/16
 * 微信: yin80871901
 */

@Service
class QiniuService(private val qiNiuProps: QiNiuProps) {

    @Throws(QiniuException::class, QiniuUploadException::class)
    fun uploadFile(file: InputStream, fileKey: String) : String {
        val config = Configuration()
        val uploadManager = UploadManager(config)
        val auth = Auth.create(qiNiuProps.accessKey, qiNiuProps.secretKey)
        val token = auth.uploadToken(qiNiuProps.bucket)
        val resp = uploadManager.put(Okio.buffer(Okio.source(file)).readByteArray(), fileKey, token)
        if (resp.isOK) {
            return resp.jsonToMap()["key"] as String
        } else {
            throw QiniuUploadException(resp.error)
        }
    }

}