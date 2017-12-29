package com.yingtaohuo.db

import com.yingtaohuo.model.ItemModel
import com.yingtaohuo.model.OrderItemModel
import com.yingtaohuo.model.OrderModel
import com.yingtaohuo.page.PageParam
import com.yingtaohuo.sso.db.tables.TItem
import com.yingtaohuo.sso.db.tables.TOrder
import com.yingtaohuo.sso.db.tables.TOrderItem
import com.yingtaohuo.sso.db.tables.records.TOrderItemRecord
import com.yingtaohuo.sso.db.tables.records.TOrderRecord
import com.zaxxer.hikari.HikariDataSource
import org.jooq.impl.DSL
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.*


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/11/8
 * 微信: yin80871901
 */

@Service
class DBOrder (private val dataSource: HikariDataSource) {

    fun loadOrderItems(orderId: Int) : List<TOrderItemRecord> {
        val tOrderItem = TOrderItem.T_ORDER_ITEM
        val tItem = TItem.T_ITEM
        dataSource.connection.use {
            DSL.using(it).use { ctx ->
                return ctx.select().from(tOrderItem).leftJoin(tItem).on(tOrderItem.ITEM_ID.eq(tItem.ID)).where(tOrderItem.ORDER_ID.eq(orderId)).map { it.into(TOrderItemRecord::class.java) }
            }
        }
    }

//    fun loadOrderItemsWithIds(orderIds: Array<Int>) : List<OrderItemModel> {
//        val tOrderItem = TOrderItem.T_ORDER_ITEM
//        val tItem = TItem.T_ITEM
//        dataSource.connection.use {
//            DSL.using(
//                    DefaultConfiguration()
//                            .set(it)
//                            .set(object : RecordMapperProvider {
//                                override fun <R : Record, E : Any> provide(recordType: RecordType<R>, type: Class<out E>): RecordMapper<R, E> {
//                                    if (type == OrderItemModel::class.java) {
//                                        return RecordMapper { record ->
//                                            val orderItemModel = OrderItemModel()
//                                            orderItemModel.id = record.get(tOrderItem.ID) as Int
//
//                                            val itemModel = ItemModel()
//                                            itemModel.id = record.get(tItem.ID)
//                                            itemModel.thumbnails = record.get(tItem.THUMBNAILS)
//                                            orderItemModel.item = itemModel
//                                            orderItemModel as E
//                                        }
//                                    }
//                                    return DefaultRecordMapper(recordType, type)
//                                }
//                            })
//            )
//                    .use { ctx ->
//                return ctx.select().from(tOrderItem).leftJoin(tItem).on(tOrderItem.ITEM_ID.eq(tItem.ID)).where(tOrderItem.ORDER_ID.`in`(*orderIds)).map { it.into(TOrderItemRecord::class.java) }
//            }
//        }
//    }

    fun loadDetailOrdersRangeShop(shopId: Int, startDate: Date, endDate: Date, page: PageParam) : List<OrderModel> {
        val orders = loadOrdersRangeShop(shopId, startDate, endDate, page)
        // orders.map { order -> }
        return emptyList()
    }

    fun loadOrdersRangeShop(shopId: Int, startDate: Date, endDate: Date, page: PageParam) : List<TOrderRecord> {
        dataSource.connection.use {
            val tOrder = TOrder.T_ORDER
            DSL.using(it).use { ctx ->
                return ctx.select().from(tOrder)
                        .where(
                                //tOrder.CORP_ID.eq(shopId).and(
                                        tOrder.CREATE_TIME.greaterOrEqual(Timestamp(startDate.time))
                                                .and(tOrder.CREATE_TIME.lessOrEqual(Timestamp(endDate.time)))
                                //)
                ).limit(page.getLimit())
                        .offset(page.getOffset())
                        .map { it.into(TOrderRecord::class.java) }
            }
        }
    }

}