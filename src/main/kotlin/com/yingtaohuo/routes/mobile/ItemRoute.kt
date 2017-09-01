package com.yingtaohuo.routes.mobile

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBCategory
import com.yingtaohuo.db.DBItem
import com.yingtaohuo.exception.NotFoundException
import com.yingtaohuo.page.Page
import com.yingtaohuo.page.PageParam
import com.yingtaohuo.util.getCurrentUser
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */
@AllOpen
@Controller
@RequestMapping("/items")
@PreAuthorize("hasRole('ADMIN')")
class ItemRoute(val dbItem: DBItem, val dbCategory: DBCategory) {

    // page view
    @GetMapping("/")
    fun itemList(model: Model, @RequestParam(defaultValue = Page.DefaultPageSizeText) pageSize: Int, @RequestParam(defaultValue = Page.DefaultPageNumText) pageNum: Int) : String {
        val user = getCurrentUser()
        val itemList = dbItem.loadPageListRangeOfShop(user.shopId, PageParam(pageNum, pageSize))
        model.addAttribute("pageNum", pageNum)
        model.addAttribute("itemList", itemList)
        model.addAttribute("title", "商品列表")
        return "mobile/item_list"
    }

    @GetMapping("/new")
    fun newItemView(model: Model) : String {
        model.addAttribute("title", "创建商品")
        return "mobile/item_new"
    }

    @GetMapping("/{id}")
    fun editItemView(@PathVariable id: Int, model: Model) : String {
        val user = getCurrentUser()
        val item = dbItem.getById(id) ?: throw NotFoundException("item id:$id not found")
        val categories = dbCategory.loadCategoryRangeShop(user.shopId)

        model.addAttribute("categories", categories)
        model.addAttribute("item", item)

        model.addAttribute("title", "修改商品")
        return "mobile/item_edit"
    }

    // form request

    @PutMapping("/{id}")
    fun updateItem() {

    }

}