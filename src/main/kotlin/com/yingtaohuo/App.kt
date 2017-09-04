package com.yingtaohuo

import com.yingtaohuo.props.AppProps
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.core.env.Environment
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

}

@ControllerAdvice
class ViewModelConfig(val appProps: AppProps, val env: Environment) {

    @ModelAttribute
    fun appConfig(model: Model) {
        appProps.envs = env.activeProfiles
        model.addAttribute("app", appProps)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}