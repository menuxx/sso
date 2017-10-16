package com.yingtaohuo

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/15
 * 微信: yin80871901
 */
class FeieException : RuntimeException {
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
}