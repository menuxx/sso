package com.yingtaohuo.db

import com.yingtaohuo.model.CategoryModel
import com.yingtaohuo.sso.db.tables.TCategory
import com.yingtaohuo.sso.db.tables.records.TCategoryRecord
import com.zaxxer.hikari.HikariDataSource
import org.jooq.impl.DSL
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/31
 * 微信: yin80871901
 */
@Service
class DBCategory(private val dataSource: HikariDataSource) : DBBase() {

    fun loadCategoryRangeShop(shopId: Int) : List<TCategoryRecord> {
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                val tCate = TCategory.T_CATEGORY
                return ctx.select().from(tCate).where(tCate.CORP_ID.eq(shopId)).fetchArray().map { cate ->
                    cate.into(TCategoryRecord::class.java)
                }
            }
        }
    }

    fun updateCategoryStatus(cateId : Int, status: Int) : Int {
        dataSource.connection.use {
            val tCate = TCategory.T_CATEGORY
            DSL.using(it).use { ctx ->
                return ctx.update(tCate).set(tCate.STATUS, status).where(tCate.STATUS.eq(cateId)).execute()
            }
        }
    }

    fun insertCategory(category: CategoryModel) : TCategoryRecord {
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                val tCate = TCategory.T_CATEGORY
                val updateRecord = toRecord<TCategoryRecord, CategoryModel>(category, true, false)
                return ctx.insertInto(tCate).set(updateRecord)
                        .returning()
                        .fetchOne()
            }
        }
    }

}