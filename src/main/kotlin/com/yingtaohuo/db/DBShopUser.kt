package com.yingtaohuo.db

import com.yingtaohuo.sso.db.tables.TCorpUser
import com.yingtaohuo.sso.db.tables.TCorpUserRole
import com.yingtaohuo.sso.db.tables.records.TCorpUserRecord
import com.zaxxer.hikari.HikariDataSource
import org.jooq.Record
import org.jooq.impl.DSL
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */
@Service
class DBShopUser(val dataSource: HikariDataSource) {

    fun getUserById(userId: Int) : TCorpUserRecord {
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                val tShopUser = TCorpUser.T_CORP_USER
                return ctx.select().from(tShopUser).where(tShopUser.ID.eq(userId)).fetchOneInto(TCorpUserRecord::class.java)
            }
        }
    }

    fun getUserDetailByTelphone(username: String?) : Record {
        val tShopUser = TCorpUser.T_CORP_USER
        val fTelphone = tShopUser.MOBILE
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                return ctx.select().from(tShopUser).where(fTelphone.eq(username)).fetchOne()
            }
        }
    }

    fun findAuthoritiesByTelphone(username: String?) : Array<out Record> {
        val tShopUserRole = TCorpUserRole.T_CORP_USER_ROLE
        val fUsername = tShopUserRole.USERNAME
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                return ctx.select().from(tShopUserRole).where(fUsername.eq(username))
                        .fetchArray()
            }
        }
    }

}