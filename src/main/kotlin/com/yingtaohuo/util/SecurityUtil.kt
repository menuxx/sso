package com.yingtaohuo.util

import com.yingtaohuo.auth.YTHAuthUser
import org.springframework.security.core.context.SecurityContextHolder

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/27
 * 微信: yin80871901
 */
fun getCurrentUser() : YTHAuthUser {
    return SecurityContextHolder.getContext().authentication.principal as YTHAuthUser
}