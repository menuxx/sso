package com.yingtaohuo.db

import com.yingtaohuo.page.PageParam
import com.yingtaohuo.sso.db.tables.TUser
import com.yingtaohuo.sso.db.tables.records.TUserRecord
import com.zaxxer.hikari.HikariDataSource
import org.jooq.impl.DSL
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/7
 * 微信: yin80871901
 */
@Service
class DBUser(private val dataSource: HikariDataSource) {

    // 取一个店铺的用户
    fun getUsersRangeOfShop(shopId: Int, page: PageParam) : List<TUserRecord> {
        val limit = page.pageSize
        val offset = (page.pageNum - 1) * page.pageSize
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                val tUser = TUser.T_USER
                return ctx.select().from(tUser)
                        .where(tUser.CORP_ID.eq(shopId))
                        .orderBy(tUser.CREATE_TIME.desc())
                        .limit(limit).offset(offset)
                        .fetchArray().map { record ->
                    record.into(TUserRecord::class.java)
                }
            }
        }
    }

}