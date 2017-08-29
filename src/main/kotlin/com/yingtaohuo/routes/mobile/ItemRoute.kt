package com.yingtaohuo.routes.mobile

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBItem
import com.yingtaohuo.exception.NotFoundException
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
class ItemRoute(val dbItem: DBItem) {

    @GetMapping("/new")
    fun newItemView() : String {
        return "mobile/item_new"
    }

    @GetMapping("/{id}")
    fun editItemView(@PathVariable id: Int, model: Model) : String {
        val item = dbItem.getById(id) ?: throw NotFoundException("item id:$id not found")
        model.addAttribute(item)
        return "mobile/item_edit"
    }

}