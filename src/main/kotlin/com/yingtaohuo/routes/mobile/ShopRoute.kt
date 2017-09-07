package com.yingtaohuo.routes.mobile

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBUser
import com.yingtaohuo.db.fromRecord
import com.yingtaohuo.model.UserModel
import com.yingtaohuo.page.Page
import com.yingtaohuo.page.PageParam
import com.yingtaohuo.resp.RespData
import com.yingtaohuo.sso.db.tables.records.TUserRecord
import com.yingtaohuo.util.getCurrentUser
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/7
 * 微信: yin80871901
 */
@AllOpen
@Controller
@RequestMapping("/shops/{shopId}")
@PreAuthorize("hasRole('ADMIN')")
class ShopRoute(val dbWXUser: DBUser) {

    @GetMapping("/users/list")
    fun getUsersView(model: Model, @RequestParam(defaultValue = Page.DefaultPageSizeText) pageSize: Int, @RequestParam(defaultValue = Page.DefaultPageNumText) pageNum: Int) : String {
        val user = getCurrentUser()
        val userList = dbWXUser.getUsersRangeOfShop(user.shopId, PageParam(pageNum, pageSize))
        model.addAttribute("pageNum", pageNum)
        model.addAttribute("user", user)
        model.addAttribute("userList", userList)
        model.addAttribute("title", "用户列表")
        return "mobile/user_list"
    }

    @GetMapping("/users")
    @ResponseBody
    fun getUsers(model: Model, @RequestParam(defaultValue = Page.DefaultPageSizeText) pageSize: Int, @RequestParam(defaultValue = Page.DefaultPageNumText) pageNum: Int) : RespData<List<UserModel>> {
        val user = getCurrentUser()
        return RespData(dbWXUser.getUsersRangeOfShop(user.shopId, PageParam(pageNum, pageSize)).map { record ->
            fromRecord<TUserRecord, UserModel>(record)
        }).success()
    }

}