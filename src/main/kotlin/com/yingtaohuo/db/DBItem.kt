package com.yingtaohuo.db

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

}