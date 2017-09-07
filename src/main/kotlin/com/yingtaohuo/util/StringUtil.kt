package com.yingtaohuo.util

import com.google.common.base.CaseFormat
import org.springframework.util.StringUtils

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/2
 * 微信: yin80871901
 */

fun fwLower(world: String) : String {
    return world[0].toLowerCase() + world.substring(1)
}

fun camelToUnderscore(world: String) : String {
    return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, world)
}

fun coverImageToThumbnails(coverImages: String?) : String? {
    return coverImages?.split("?")?.filterNot { url -> StringUtils.isEmpty(url)  }?.map { url -> "$url?imageView2/2/w/200/h/200" }?.joinToString(":")
}