package com.yingtaohuo.routes.mobile

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/mock/")
@Controller
class MockRoute {

    @GetMapping("/login")
    fun page2(model: Model) : String {
        model.addAttribute("title", "111")
        return "mobile/login"
    }

    @GetMapping("/order_list")
    fun page3(model: Model) : String {
        model.addAttribute("title", "111")
        return "mobile/order_list"
    }

    @GetMapping("/statistics")
    fun page4(model: Model) : String {
        model.addAttribute("title", "111")
        return "mobile/statistics"
    }
}