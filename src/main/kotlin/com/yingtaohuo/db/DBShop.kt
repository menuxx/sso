package com.yingtaohuo.db

import com.yingtaohuo.page.PageParam
import com.yingtaohuo.sso.db.tables.TConfig
import com.yingtaohuo.sso.db.tables.TCorp
import com.yingtaohuo.sso.db.tables.records.TConfigRecord
import com.yingtaohuo.sso.db.tables.records.TCorpRecord
import com.zaxxer.hikari.HikariDataSource
import org.jooq.impl.DSL
import org.jooq.types.UInteger
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/18
 * 微信: yin80871901
 */
@Service
class DBShop(private val dataSource: HikariDataSource) {

    fun updateTimeline(corpId: Int, timeline: String) : Int {
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                val tConfig = TConfig.T_CONFIG
                val _config = ctx.select().from(tConfig)
                        .where(tConfig.CORP_ID.eq(corpId).and(tConfig.NAME.eq("business_timeline"))).fetchOne().into(TConfigRecord::class.java)
                return if (_config == null) {
                    ctx.insertInto(tConfig, tConfig.CORP_ID, tConfig.NAME, tConfig.VALUE).values(corpId, "business_timeline", timeline).execute()
                } else {
                    ctx.update(tConfig)
                            .set(tConfig.VALUE, timeline)
                            .where(tConfig.NAME.eq("business_timeline").and(tConfig.CORP_ID.eq(corpId))).execute()
                }
            }
        }
    }

    fun getShopById(shopId: Int) : TCorpRecord {
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                val tCorp = TCorp.T_CORP
                return ctx.select().from(tCorp).where(tCorp.ID.eq(UInteger.valueOf(shopId))).fetchOne().into(TCorpRecord::class.java)
            }
        }
    }

    fun loadShops(page: PageParam) : List<TCorpRecord> {
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                val tCorp = TCorp.T_CORP
                return ctx.select().from(tCorp).limit(page.getLimit()).offset(page.getOffset()).fetchArray().map { record ->
                    record.into(TCorpRecord::class.java)
                }
            }
        }
    }

}