package com.yingtaohuo.db

import com.yingtaohuo.sso.db.tables.*
import com.yingtaohuo.sso.db.tables.records.TCorpUserRecord
import com.zaxxer.hikari.HikariDataSource
import org.jooq.Record
import org.jooq.impl.DSL
import org.jooq.types.UInteger
import org.springframework.stereotype.Service

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
                return ctx.select().from(tShopUser).where(tShopUser.ID.eq(UInteger.valueOf(userId))).fetchOneInto(TCorpUserRecord::class.java)
            }
        }
    }

    fun getUserDetailByTelphone(mobile: String) : TCorpUserRecord? {
        val tShopUser = TCorpUser.T_CORP_USER
        val fMobile = tShopUser.MOBILE
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                return ctx.select().from(tShopUser).where(fMobile.eq(mobile)).fetchOne()?.into(TCorpUserRecord::class.java)
            }
        }
    }

    fun findAuthoritiesByTelphone(mobile: String) : Array<out Record> {
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                // select * from t_admin left join t_user_authority on t_admin.id = t_user_authority.user_id left join t_authority on t_user_authority.authority_id = t_authority.id where t_admin.mobile = "13575762817"
                val tShopUser = TCorpUser.T_CORP_USER
                val tUserAuthority = TUserAuthority.T_USER_AUTHORITY
                val tAuthority = TAuthority.T_AUTHORITY
                return ctx.select().from(tShopUser).leftJoin(tUserAuthority).on(tShopUser.ID.eq(tUserAuthority.USER_ID)).leftJoin(tAuthority).on(tUserAuthority.AUTHORITY_ID.eq(tAuthority.ID)).where(tShopUser.MOBILE.eq(mobile)).fetchArray()
            }
        }
    }

    fun loadUsersByShopId(shopId: Int) : List<TCorpUserRecord> {
        val tShopUser = TCorpUser.T_CORP_USER
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                return ctx.select().from(tShopUser).where(tShopUser.CORP_ID.eq(shopId))
                        .fetchArray().map {
                    it.into(TCorpUserRecord::class.java)
                }
            }
        }
    }

    fun updateWxUserId(mobile: String, userId: Int) : Int {
        val tShopUser = TCorpUser.T_CORP_USER
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                return ctx.update(tShopUser)
                        .set(tShopUser.WX_USER_ID, UInteger.valueOf(userId))
                        .where(tShopUser.MOBILE.eq(mobile))
                        .execute()
            }
        }
    }

    fun getUserByWxUserId(wxUserId: Int) : TCorpUserRecord? {
        val tShopUser = TCorpUser.T_CORP_USER
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                return ctx.select().from(tShopUser)
                        .where(tShopUser.WX_USER_ID.eq(UInteger.valueOf(wxUserId)))
                        .fetchOneInto(TCorpUserRecord::class.java)
            }
        }
    }

}