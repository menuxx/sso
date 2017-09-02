package com.yingtaohuo

import com.yingtaohuo.db.DBItem
import com.yingtaohuo.page.PageParam
import com.yingtaohuo.props.AppProps
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */
@SpringBootApplication(scanBasePackages = arrayOf("com.yingtaohuo", "com.yingtaohuo.*"))
@EnableGlobalMethodSecurity(securedEnabled = true)
class App {

    @Bean
    fun testListPage(dbItem: DBItem): CommandLineRunner {
        return CommandLineRunner {
            dbItem.loadPageListRangeOfShop(4, PageParam(2, 2)).forEach { item ->
                println(item)
            }
        }
    }

}

@ControllerAdvice
class ViewModelConfig(val appProps: AppProps) {

    @ModelAttribute
    fun appConfig(model: Model) {
        model.addAttribute("app", appProps)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}