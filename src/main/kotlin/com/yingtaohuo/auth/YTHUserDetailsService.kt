package com.yingtaohuo.auth

import com.yingtaohuo.db.DBShopUser
import com.yingtaohuo.sso.db.tables.TCorpUserRole
import com.yingtaohuo.sso.db.tables.records.TCorpUserRecord
import com.yingtaohuo.util.toBool
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */

@Service
class YTHUserDetailsService(val dbShopUser: DBShopUser) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails {
        val shopUser = dbShopUser.getUserDetailByTelphone(username).into(TCorpUserRecord::class.java)
        val authorities = dbShopUser.findAuthoritiesByTelphone(username).map { YTHGrantedAuthority(it[TCorpUserRole.T_CORP_USER_ROLE.ROLE]) }.toMutableList()
        return YTHAuthUser(
                shopUser.id,
                shopUser.corpId,
                shopUser.nickname,
                shopUser.email,
                shopUser.mobile,
                toBool(shopUser.enabled),
                shopUser.captcha,
                shopUser.lastLoginTime,
                authorities
        )
    }

}