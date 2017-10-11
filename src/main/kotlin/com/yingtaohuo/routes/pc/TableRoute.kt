package com.yingtaohuo.routes.pc

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBTable
import com.yingtaohuo.db.fromRecord
import com.yingtaohuo.model.TableModel
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

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

    data class NewTable(@NotEmpty val tableName: String)
    @GetMapping("/")
    @ResponseBody
    fun newTable(@PathVariable shopId: Int, @RequestBody table: NewTable) : TableModel {
        val model = TableModel()
        model.corpId = shopId
        model.tableName = table.tableName
        return fromRecord(dbTable.insertTableToShop(tableModel = model, shopId = shopId))
    }

}