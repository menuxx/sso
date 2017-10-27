package com.yingtaohuo.resp


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */

data class RespMeta(var error: String, var errorCode: Int, val extra: Map<String, Any>?)

data class RespData<out T>(val data: T?, var meta: RespMeta?=null) {
    fun success() : RespData<T> {
        if (meta == null) {
            meta = RespMeta("ok", 0, null)
        }
        return this
    }
    fun success(extra: Map<String, Any>?) : RespData<T> {
        if (meta == null) {
            meta = RespMeta("ok", 0, extra)
        }
        return this
    }
    fun failed(error: String, errorCode: Int) : RespData<T> {
        if (meta == null) {
            meta = RespMeta(error, errorCode, null)
        }
        return this
    }
}

data class RespPageMeta(var error: String, var errorCode: Int, val pageSize: Int, val pageNum: Int, val lastPage: Boolean)

data class RespPageData<out T>(val data: T?, var meta: RespPageMeta?=null)