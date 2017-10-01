package com.yingtaohuo.routes.mobile

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBCategory
import com.yingtaohuo.db.DBShop
import com.yingtaohuo.db.DBUser
import com.yingtaohuo.db.fromRecord
import com.yingtaohuo.model.UserModel
import com.yingtaohuo.page.Page
import com.yingtaohuo.page.PageParam
import com.yingtaohuo.resp.RespData
import com.yingtaohuo.sso.db.tables.records.TUserRecord
import com.yingtaohuo.util.getCurrentUser
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/7
 * 微信: yin80871901c
 */
@AllOpen
@Controller
@RequestMapping("/shops/{shopId}")
@PreAuthorize("hasRole('ADMIN')")
class ShopRoute(val dbUser: DBUser, val dbShop: DBShop, val dbCategory: DBCategory) {

    @GetMapping("category_list")
    fun categoryListView(model: Model) : String {
        val user = getCurrentUser()
        val categories = dbCategory.loadCategoryRangeShop(user.shopId)
        model.addAttribute("title", "分类管理")
        model.addAttribute("categories", categories)
        return "mobile/category_list"
    }

    @GetMapping("/users/list")
    fun getUsersView(model: Model, @RequestParam(defaultValue = Page.DefaultPageSizeText) pageSize: Int, @RequestParam(defaultValue = Page.DefaultPageNumText) pageNum: Int) : String {
        val user = getCurrentUser()
        val userList = dbUser.getUsersRangeOfShop(user.shopId, PageParam(pageNum, pageSize))
        val userCount = dbUser.getTotalCountOfShop(user.shopId)
        model.addAttribute("userCount", userCount)
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
        return RespData(dbUser.getUsersRangeOfShop(user.shopId, PageParam(pageNum, pageSize)).map { record ->
            fromRecord<TUserRecord, UserModel>(record)
        }).success()
    }

    @GetMapping("/")
    fun myShop(@PathVariable("shopId") shopId: Int, model: Model) : String {
        val user = getCurrentUser()
        val shop = dbShop.getShopById(user.shopId)
        model.addAttribute("shop", shop)
        return "myshop"
    }

    data class BusinessTimeline(@NotEmpty val businessTimeline: String)
    @PutMapping("/business_timeline")
    @ResponseBody
    fun updateBusinessTimeline(@PathVariable("shopId") shopId: Int,
                               @Valid @RequestBody timeline: BusinessTimeline) : RespData<Int> {
        val user = getCurrentUser()
        return RespData(dbShop.updateTimeline(user.shopId, timeline.businessTimeline)).success()
    }

}