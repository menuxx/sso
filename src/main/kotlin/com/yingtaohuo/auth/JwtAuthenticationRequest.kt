package com.yingtaohuo.auth

import com.yingtaohuo.NoArg
import org.hibernate.validator.constraints.NotEmpty

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/14
 * 微信: yin80871901
 */
@NoArg
data class JwtAuthenticationRequest(
        @NotEmpty(message = "手机号必填") val mobile: String,
        @NotEmpty(message = "密码不能为空") val password: String
)