package com.yingtaohuo.db

import com.yingtaohuo.model.ItemModel
import com.yingtaohuo.page.PageParam
import com.yingtaohuo.sso.db.tables.TItem
import com.yingtaohuo.sso.db.tables.records.TItemRecord
import com.zaxxer.hikari.HikariDataSource
import org.jooq.impl.DSL
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/28
 * 微信: yin80871901
 */
@Service
class DBItem(private val dataSource: HikariDataSource) {

    private val logger = LoggerFactory.getLogger(DBItem::class.java)

    fun getById(itemId: Int, withShopId: Int) : TItemRecord? {
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                val tItem = TItem.T_ITEM
                return ctx.select().from(tItem)
                        .where(tItem.ID.eq(itemId).and(tItem.CORP_ID.eq(withShopId)))
                        .fetchOneInto(TItemRecord::class.java)
            }
        }
    }

    fun loadPageListByCategroyRangeOfShop(shopId: Int, categoryId: Int, page: PageParam) : List<TItemRecord> {
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                val tItem = TItem.T_ITEM
                val limit = page.pageSize
                val offset = (page.pageNum - 1) * page.pageSize
                return ctx.select().from(tItem)
                        .where(tItem.CORP_ID.eq(shopId).and(tItem.CATEGORY_ID.eq(categoryId)))
                        .orderBy(tItem.CREATE_TIME.desc())
                        .limit(limit).offset(offset)
                        .fetchArray()
                        .map { record ->
                    record.into(TItemRecord::class.java)
                }
            }
        }
    }

    @Transactional
    fun updateItemById(itemId: Int, itemModel: ItemModel, withShopId: Int) : Int {
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                val tItem = TItem.T_ITEM
                val updateRecord = toRecord<TItemRecord, ItemModel>(itemModel, true, false)
                if ( logger.isDebugEnabled ) logger.debug(updateRecord.toString())
                return ctx.update(tItem)
                        .set(updateRecord)
                        .where(tItem.ID.eq(itemId).and(tItem.CORP_ID.eq(withShopId)))
                        .execute()
            }
        }
    }

    fun insertItem(itemModel: ItemModel) : TItemRecord {
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                val tItem = TItem.T_ITEM
                val record = toRecord<TItemRecord, ItemModel>(itemModel, false, true)
                return ctx.insertInto(tItem)
                        .set(record)
                        .returning()
                        .fetchOne()
            }
        }
    }

}