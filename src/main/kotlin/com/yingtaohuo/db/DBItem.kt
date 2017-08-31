package com.yingtaohuo.db

import com.yingtaohuo.page.PageParam
import com.yingtaohuo.sso.db.tables.TItem
import com.yingtaohuo.sso.db.tables.records.TItemRecord
import org.jooq.impl.DSL
import org.springframework.stereotype.Service
import javax.sql.DataSource

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/28
 * 微信: yin80871901
 */
@Service
class DBItem(private val dataSource: DataSource) {

    fun getById(itemId: Int) : TItemRecord? {
        DSL.using(dataSource.connection).use { ctx ->
            val tItem = TItem.T_ITEM
            return ctx.select().from(tItem).where(tItem.ID.eq(itemId)).fetchOneInto(TItemRecord::class.java)
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

}