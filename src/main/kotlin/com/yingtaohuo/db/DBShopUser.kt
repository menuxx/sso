package com.yingtaohuo.db

import com.yingtaohuo.sso.db.tables.TCorpUser
import com.yingtaohuo.sso.db.tables.TCorpUserRole
import com.yingtaohuo.sso.db.tables.records.TCorpUserRecord
import org.jooq.Record
import org.jooq.impl.DSL
import org.springframework.stereotype.Service
import javax.sql.DataSource

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */
@Service
class DBShopUser(val dataSource: DataSource) {

    fun getUserById(userId: Int) : TCorpUserRecord {
        DSL.using(dataSource.connection).use { ctx ->
            val tShopUser = TCorpUser.T_CORP_USER
            return ctx.select().from(tShopUser).where(tShopUser.ID.eq(userId)).fetchOneInto(TCorpUserRecord::class.java)
        }
    }

    fun getUserDetailByTelphone(username: String?) : Record {
        val tShopUser = TCorpUser.T_CORP_USER
        val fTelphone = tShopUser.MOBILE
        DSL.using(dataSource.connection).use { ctx ->
            return ctx.select().from(tShopUser).where(fTelphone.eq(username)).fetchOne()
        }
    }

    fun findAuthoritiesByTelphone(username: String?) : Array<out Record> {
        val tShopUserRole = TCorpUserRole.T_CORP_USER_ROLE
        val fUsername = tShopUserRole.USERNAME
        DSL.using(dataSource.connection).use { ctx ->
            return ctx.select().from(tShopUserRole).where(fUsername.eq(username))
                    .fetchArray()
        }
    }

}