package com.yingtaohuo.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/27
 * 微信: yin80871901
 */
class YTHGrantedAuthority(private val authorize: String) : GrantedAuthority {
    override fun getAuthority(): String {
        return authorize
    }
}

class YTHAuthUser(
        val id: Int,
        val shopId: Int,
        var nickname: String?,
        var email: String?,
        val telphone: String,
        val enabled: Boolean,
        val captcha: String?,
        val lastLoginTime: Date,
        private val authorities: MutableList<YTHGrantedAuthority>?= mutableListOf()
) : UserDetails {

    // 用户权限
    override fun getAuthorities() = authorities

    // 用户是否激活
    override fun isEnabled() = enabled

    // 用户名
    override fun getUsername() = telphone

    // 证书尚未过期
    override fun isCredentialsNonExpired() = true

    // 密码
    override fun getPassword() = captcha

    // 账户尚未过期
    override fun isAccountNonExpired() = true

    // 账户未被锁定
    override fun isAccountNonLocked() = true

}