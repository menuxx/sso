package com.yingtaohuo.routes.pc

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBTable
import com.yingtaohuo.db.TableStatusOfDisable
import com.yingtaohuo.db.fromRecord
import com.yingtaohuo.model.TableModel
import com.yingtaohuo.resp.RespData
import com.yingtaohuo.util.getCurrentUser
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
@RequestMapping("/tables")
@PreAuthorize("hasRole('ADMIN')")
class TableRoute (val dbTable: DBTable) {

    @GetMapping("/list")
    fun tableListView(model: Model) : String {
        val user = getCurrentUser()
        val tables = dbTable.getTablesRangeOfShop(user.shopId)
        model.addAttribute("user", user)
        model.addAttribute("title", "桌子")
        model.addAttribute("tables", tables)
        return "pc/table_list"
    }

    data class NewTable(@NotEmpty val tableName: String)
    @PostMapping("/")
    @ResponseBody
    fun newTable(@RequestBody table: NewTable) : TableModel {
        val model = TableModel()
        val user = getCurrentUser()
        model.corpId = user.shopId
        model.tableName = table.tableName
        return fromRecord(dbTable.insertTableToShop(tableModel = model, shopId = user.shopId))
    }

    @PutMapping("/{tableId}")
    @ResponseBody
    fun delTable(@PathVariable tableId: Int) : RespData<Int> {
        return RespData(dbTable.updateTableStatus(tableId, TableStatusOfDisable)).success()
    }



}