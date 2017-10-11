package com.yingtaohuo.routes.pc

import com.yingtaohuo.AllOpen
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/10
 * 微信: yin80871901
 */
@AllOpen
@Controller
@RequestMapping("/auth")
class AuthRoute {

    @GetMapping("/login")
    fun loginView() : String {
        return "pc/login"
    }

}