package com.yingtaohuo.db

import com.yingtaohuo.sso.db.tables.TAdmin
import com.yingtaohuo.sso.db.tables.TAuthority
import com.yingtaohuo.sso.db.tables.TUserAuthority
import com.yingtaohuo.sso.db.tables.records.TAdminRecord
import com.zaxxer.hikari.HikariDataSource
import org.jooq.Record
import org.jooq.impl.DSL
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/14
 * 微信: yin80871901
 */
@Service
class DBAdminUser(val dataSource: HikariDataSource) {

    fun getUserDetailByMobile(username: String?) : TAdminRecord? {
        val tAdmin = TAdmin.T_ADMIN
        val fMobile = tAdmin.MOBILE
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                return ctx.select().from(tAdmin).where(fMobile.eq(username)).fetchOne().into(TAdminRecord::class.java)
            }
        }
    }

    fun findAuthoritiesByMobile(mobile: String?) : Array<out Record> {
        // select * from t_admin left join t_user_authority on t_admin.id = t_user_authority.user_id left join t_authority on t_user_authority.authority_id = t_authority.id where t_admin.mobile = "13575762817"
        val tAdmin = TAdmin.T_ADMIN
        val tUserAuthority = TUserAuthority.T_USER_AUTHORITY
        val tAuthority = TAuthority.T_AUTHORITY
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                return ctx.select().from(tAdmin).leftJoin(tUserAuthority).on(tAdmin.ID.eq(tUserAuthority.USER_ID)).leftJoin(tAuthority).on(tUserAuthority.AUTHORITY_ID.eq(tAuthority.ID)).where(tAdmin.MOBILE.eq(mobile)).fetchArray()
            }
        }
    }

}