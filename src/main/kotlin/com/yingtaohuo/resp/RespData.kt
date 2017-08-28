package com.yingtaohuo.resp

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */

data class RespMeta(var error: String, var errorCode: Int)

data class RespData(val data: Any, var meta: RespMeta?=null) {
    fun success() : RespData {
        if (meta == null) {
            meta = RespMeta("ok", 0)
        }
        return this
    }
    fun failed(error: String, errorCode: Int) : RespData {
        if (meta == null) {
            meta = RespMeta(error, errorCode)
        }
        return this
    }
}