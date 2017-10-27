package com.yingtaohuo.auth

import com.yingtaohuo.db.DBAdminUser
import com.yingtaohuo.db.DBShopUser
import com.yingtaohuo.sso.db.tables.TAuthority
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

@Service("userDetailsService")
class YTHUserDetailsService(val dbShopUser: DBShopUser) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails? {
        // 代理
        val shopUser: TCorpUserRecord? = dbShopUser.getUserDetailByTelphone(username)
        return if ( shopUser != null ) {
            // var authorities = dbShopUser.findAuthoritiesByTelphone(username).map { YTHGrantedAuthority(it[TAuthority.T_AUTHORITY.NAME]) }.toMutableList()
            // if ( authorities.isEmpty() ) {
             val authorities = mutableListOf(YTHGrantedAuthority("USER"))
            // }
            YTHAuthUser(
                    shopUser.id.toInt(),
                    shopUser.corpId,
                    shopUser.nickname,
                    shopUser.email,
                    shopUser.mobile,
                    toBool(shopUser.enabled),
                    null,
                    shopUser.lastLoginTime,
                    authorities
            )
        } else null
    }

}

@Service("adminDetailsService")
class YTHAdminDetailsService(val dbAdminUser: DBAdminUser) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(mobile: String): UserDetails? {
        val adminUser = dbAdminUser.getUserDetailByMobile(mobile)
        return if ( adminUser != null ) {
            val authorities = dbAdminUser.findAuthoritiesByMobile(mobile).map { YTHGrantedAuthority(it[TAuthority.T_AUTHORITY.NAME]) }.toMutableList()
            YTHAuthUser(
                    adminUser.id.toInt(),
                    1,
                    adminUser.nickname,
                    adminUser.email,
                    adminUser.mobile,
                    toBool(adminUser.enable),
                    adminUser.password,
                    adminUser.lastLoginAt,
                    authorities
            )
        } else null
    }

}