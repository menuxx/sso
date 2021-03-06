package com.yingtaohuo.routes.mobile

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBShop
import com.yingtaohuo.util.getCurrentUser
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/7
 * 微信: yin80871901
 */
@AllOpen
@Controller
@RequestMapping("/")
@PreAuthorize("hasRole('USER')")
class IndexRoute(val dbShop: DBShop) {

    @GetMapping
    fun indexView(mode: Model) : String {
        val user = getCurrentUser()
        val shop = dbShop.getShopById(user.shopId)
        mode.addAttribute("shop", shop)
        mode.addAttribute("user", user)
        mode.addAttribute("title", "商户管理平台")
        return "mobile/index"
    }

}