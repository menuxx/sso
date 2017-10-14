package com.yingtaohuo.mode

import com.yingtaohuo.NoArg
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/27
 * 微信: yin80871901
 */
@NoArg
data class CorpUser(
        val id: Int,
        val pushKey: String,
        val mobile: String,
        val nickname: String,
        val gender: String,
        val avatar: String,
        val email: String,
        val createTime: Date,
        val enabled: Int,
        val captcha: String,
        val lastLoginTime: Date
)

@NoArg
data class UserTokenState(val accessToken: String, val expiresIn: Int)