package com.yingtaohuo.routes.mobile

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBItem
import com.yingtaohuo.exception.NotFoundException
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */
@Controller
@RequestMapping("/items")
@PreAuthorize("hasRole('ADMIN')")
@AllOpen
class ItemRoute(val dbItem: DBItem) {

    @GetMapping
    fun newItemView() : String {
        return "edit_new"
    }

    @GetMapping("/{id}")
    fun editItemView(@PathVariable id: Int, model: Model) : String {
        val item = dbItem.getById(id) ?: throw NotFoundException("item id:$id not found")
        model.addAttribute(item)
        return "edit_item"
    }



}

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun error(ex: Exception) {
        ex.printStackTrace()
    }

}