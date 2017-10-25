package com.yingtaohuo.wechat

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/17
 * 微信: yin80871901
 */

class WXException(message: String, val errorCode: Int) : RuntimeException(message)