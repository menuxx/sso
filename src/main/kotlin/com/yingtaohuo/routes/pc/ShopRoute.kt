package com.yingtaohuo.routes.pc

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBShop
import com.yingtaohuo.page.Page
import com.yingtaohuo.page.PageParam
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/12
 * 微信: yin80871901
 */
@AllOpen
@Controller
@RequestMapping("/shops")
@PreAuthorize("hasRole('ADMIN')")
class ShopRoute(val dbShop: DBShop) {

    @GetMapping("/list")
    fun listView(model: Model, @RequestParam(defaultValue = Page.DefaultPageSizeText) pageSize: Int, @RequestParam(defaultValue = Page.DefaultPageNumText) pageNum: Int) : String {
        val shops = dbShop.loadShops(PageParam(pageNum, pageSize))
        model.addAttribute("title", "店铺列表")
        model.addAttribute("shops", shops)
        return "pc/shops"
    }

}