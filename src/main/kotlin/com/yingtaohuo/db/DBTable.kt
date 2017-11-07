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

val TableStatusOfDisable = 0
val TableStatusOfEnable = 1

@Service
class DBTable (private val dataSource: HikariDataSource ) : DBBase() {

    fun getTableById(tableId: Int) : TTableRecord? {
        dataSource.connection.use { it ->
            val tTable = TTable.T_TABLE
            DSL.using(it).use { ctx ->
                return ctx.select().from(tTable).where(tTable.ID.eq(tableId)).fetchOne().map { t ->
                    t.into(TTableRecord::class.java)
                }
            }
        }
    }

    fun getTablesRangeOfShop(shopId: Int) : List<TTableRecord> {
        dataSource.connection.use { it ->
            val tTable = TTable.T_TABLE
            DSL.using(it).use { ctx ->
                return ctx.select().from(tTable)
                        .where(tTable.CORP_ID.eq(shopId).and(tTable.STATUS.eq(TableStatusOfEnable)))
                        .fetchArray().map { t ->
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

    fun updateTableStatus(tableId: Int, status: Int) : Int {
        dataSource.connection.use { it ->
            val tTable = TTable.T_TABLE
            DSL.using(it).use { ctx ->
                return ctx.update(tTable).set(tTable.STATUS, status).where(tTable.ID.eq(tableId)).execute()
            }
        }
    }

    fun updateTable(tableId: Int, qrCodeData: String, qrCodeUrl: String, qrCodePagePath: String) : Int {
        dataSource.connection.use { it ->
            val tTable = TTable.T_TABLE
            DSL.using(it).use { ctx ->
                return ctx.update(tTable)
                        .set(tTable.WX_QRCODE_DATA, qrCodeData)
                        .set(tTable.WX_QRCODE_URL, qrCodeUrl)
                        .set(tTable.WX_QRCODE_PATH, qrCodePagePath)
                        .where(tTable.ID.eq(tableId)).execute()
            }
        }
    }

}