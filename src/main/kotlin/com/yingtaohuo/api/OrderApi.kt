package com.yingtaohuo.api

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBOrder
import com.yingtaohuo.page.Page
import com.yingtaohuo.page.PageParam
import com.yingtaohuo.util.getCurrentUser
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/11/8
 * 微信: yin80871901
 */
@AllOpen
@RestController
@RequestMapping("/orders")
@PreAuthorize("hasRole('USER')")
class OrderApi ( val dbOrder: DBOrder ) {

    @GetMapping(produces = arrayOf("application/json"))
    fun loadOrders(@RequestParam startDate: Long, @RequestParam endDate: Long, @RequestParam(defaultValue = Page.DefaultPageSizeText) pageSize: Int, @RequestParam(defaultValue = Page.DefaultPageNumText) pageNum: Int) : String {
        val user = getCurrentUser()
        val orders = dbOrder.loadDetailOrdersRangeShop(user.shopId, Date(startDate), Date(endDate), PageParam(pageNum, pageSize))
        return ""
    }

}