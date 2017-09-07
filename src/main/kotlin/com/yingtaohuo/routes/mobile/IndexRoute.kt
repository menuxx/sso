package com.yingtaohuo.routes.mobile

import com.yingtaohuo.AllOpen
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/7
 * 微信: yin80871901
 */
@AllOpen
@Controller
@RequestMapping("/")
@PreAuthorize("hasRole('ADMIN')")
class IndexRoute {

}