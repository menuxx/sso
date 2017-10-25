package com.yingtaohuo.db

import com.yingtaohuo.model.WXUserModel
import com.yingtaohuo.sso.db.tables.TWxUser
import com.yingtaohuo.sso.db.tables.records.TWxUserRecord
import com.zaxxer.hikari.HikariDataSource
import org.jooq.impl.DSL
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/18
 * 微信: yin80871901
 */
@Service
class DBWXUser(private val dataSource: HikariDataSource) {

    fun findUserByOpenid(openid: String) : TWxUserRecord? {
        val tWxUser = TWxUser.T_WX_USER
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                return ctx.select().from(tWxUser).where(tWxUser.OPENID.eq(openid)).fetchOne().into(TWxUserRecord::class.java)
            }
        }
    }

    fun findUserByUnionid(unionid: String) : TWxUserRecord? {
        val tWxUser = TWxUser.T_WX_USER
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                return ctx.select().from(tWxUser).where(tWxUser.UNIONID.eq(unionid)).fetchOne().into(TWxUserRecord::class.java)
            }
        }
    }

    fun insertUser(user: WXUserModel) : TWxUserRecord {
        val tWxUser = TWxUser.T_WX_USER
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                return ctx.insertInto(tWxUser)
                        .set(toRecord<TWxUserRecord, WXUserModel>(user, false, true))
                        .returning().fetchOne()
            }
        }
    }

    fun updateUser(user: WXUserModel) : TWxUserRecord {
        val tWxUser = TWxUser.T_WX_USER
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                return ctx.update(tWxUser)
                        .set(toRecord<TWxUserRecord, WXUserModel>(user, false, true))
                        .where(tWxUser.UNIONID.eq(user.unionid))
                        .returning()
                        .fetchOne()
            }
        }
    }

}