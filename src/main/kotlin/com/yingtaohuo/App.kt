package com.yingtaohuo

import com.yingtaohuo.props.AppProps
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.core.env.Environment
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.context.annotation.Bean
import org.jooq.impl.TableRecordImpl
import com.fasterxml.jackson.databind.introspect.AnnotatedMember
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */
@SpringBootApplication(scanBasePackages = arrayOf("com.yingtaohuo", "com.yingtaohuo.*"))
@EnableGlobalMethodSecurity(securedEnabled = true)
class App {

    // // http://stackoverflow.com/questions/26945580/jackson-serialization-how-to-ignore-superclass-properties
    private class IgnoreInheritedIntrospector : JacksonAnnotationIntrospector() {
        override fun hasIgnoreMarker(m: AnnotatedMember?): Boolean {
            return m!!.declaringClass == TableRecordImpl::class.java || super.hasIgnoreMarker(m)
        }
    }

    @Bean
    fun objectMapperBuilder(): Jackson2ObjectMapperBuilder {
        val builder = Jackson2ObjectMapperBuilder()
        builder.annotationIntrospector(IgnoreInheritedIntrospector())
        builder.serializationInclusion(JsonInclude.Include.NON_NULL)
        return builder
    }

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