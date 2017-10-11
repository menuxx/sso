package com.yingtaohuo.db

import com.yingtaohuo.model.TableModel
import com.yingtaohuo.sso.db.tables.TTable
import com.yingtaohuo.sso.db.tables.records.TTableRecord
import com.zaxxer.hikari.HikariDataSource
import org.jooq.Record
import org.jooq.impl.DSL
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/26
 * 微信: yin80871901
 */
@Service
class DBTable ( val dataSource: HikariDataSource ) {

    fun getTablesRangeOfShop(shopId: Int) : List<TTableRecord> {
        dataSource.connection.use { it ->
            val tTable = TTable.T_TABLE
            DSL.using(it).use { ctx ->
                return ctx.select().from(tTable).where(tTable.CORP_ID.eq(shopId)).fetchArray().map { t ->
                    t.into(TTableRecord::class.java)
                }
            }
        }
    }

    fun insertTableToShop(tableModel: TableModel, shopId: Int) : TTableRecord {
        dataSource.connection.use { it ->
            val tTable = TTable.T_TABLE
            DSL.using(it).use { ctx ->
                val record = toRecord<TTableRecord, TableModel>(tableModel, false, true)
                return ctx.insertInto(tTable).set(record).returning().fetchOne()
            }
        }
    }

}