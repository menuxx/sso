package com.yingtaohuo.routes.pc

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBTable
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/26
 * 微信: yin80871901
 */
@AllOpen
@Controller
@RequestMapping("/shops/{shopId}/tables")
@PreAuthorize("hasRole('ADMIN')")
class TableRoute (val dbTable: DBTable) {

    @GetMapping("/list")
    fun tableListView(@PathVariable shopId: Int, model: Model) : String {
        val tables = dbTable.getTablesRangeOfShop(shopId)
        model.addAttribute("title", "桌子")
        model.addAttribute("tables", tables)
        return "pc/table_list"
    }

}