package com.yingtaohuo.db

import com.yingtaohuo.model.ItemModel
import com.yingtaohuo.page.PageParam
import com.yingtaohuo.sso.db.tables.TItem
import com.yingtaohuo.sso.db.tables.records.TItemRecord
import org.jooq.impl.DSL
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.sql.DataSource

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/28
 * 微信: yin80871901
 */
@Service
class DBItem(private val dataSource: DataSource) {

    private val logger = LoggerFactory.getLogger(DBItem::class.java)

    fun getById(itemId: Int, withShopId: Int) : TItemRecord? {
        DSL.using(dataSource.connection).use { ctx ->
            val tItem = TItem.T_ITEM
            return ctx.select().from(tItem)
                    .where(tItem.ID.eq(itemId).and(tItem.CORP_ID.eq(withShopId)))
                    .fetchOneInto(TItemRecord::class.java)
        }
    }

    fun loadPageListRangeOfShop(shopId: Int, page: PageParam) : List<TItemRecord> {
        DSL.using(dataSource.connection).use { ctx ->
            val tItem = TItem.T_ITEM
            val limit = page.pageSize
            val offset = (page.pageNum - 1) * page.pageSize
            return ctx.select().from(tItem).where(tItem.CORP_ID.eq(shopId)).limit(limit).offset(offset).fetchArray().map { record ->
                record.into(TItemRecord::class.java)
            }
        }
    }

    fun updateItemById(itemId: Int, itemModel: ItemModel, withShopId: Int) : Int {
        DSL.using(dataSource.connection).use { ctx ->
            val tItem = TItem.T_ITEM
            val updateRecord = toRecord<TItemRecord, ItemModel>(itemModel)
            if ( logger.isDebugEnabled ) logger.debug(updateRecord.toString())
            return ctx.update(tItem)
                    .set(updateRecord)
                    .where(tItem.ID.eq(itemId).and(tItem.CORP_ID.eq(withShopId)))
                    .execute()
        }
    }

}