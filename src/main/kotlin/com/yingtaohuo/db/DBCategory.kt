package com.yingtaohuo.db

import com.yingtaohuo.sso.db.tables.TCategory
import com.yingtaohuo.sso.db.tables.records.TCategoryRecord
import org.jooq.impl.DSL
import org.springframework.stereotype.Service
import javax.sql.DataSource

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/31
 * 微信: yin80871901
 */
@Service
class DBCategory(private val dataSource: DataSource) {

    fun loadCategoryRangeShop(shopId: Int) : List<TCategoryRecord> {
        DSL.using(dataSource.connection).use { ctx ->
            val tCate = TCategory.T_CATEGORY
            return ctx.select().from(tCate).where(tCate.CORP_ID.eq(shopId)).fetchArray().map { cate ->
                cate.into(TCategoryRecord::class.java)
            }
        }
    }

}