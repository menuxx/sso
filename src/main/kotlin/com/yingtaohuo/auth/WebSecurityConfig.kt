package com.yingtaohuo.auth

import com.yingtaohuo.db.DBShopUser
import com.yingtaohuo.service.CaptchaService
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.core.annotation.Order
import org.springframework.http.HttpMethod
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class WebSecurityConfig(
        private val userService: YTHUserDetailsService,
        private val dbShopUser: DBShopUser
) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

        http.csrf()
                .disable()
                .exceptionHandling().authenticationEntryPoint(AuthTokenAuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()

        http.addFilterBefore(AuthTokenAuthenticationTokenFilter(userService, dbShopUser), UsernamePasswordAuthenticationFilter::class.java)
        http.headers().cacheControl()
    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(builder: AuthenticationManagerBuilder) {
        builder.userDetailsService(userService).passwordEncoder(BCryptPasswordEncoder())

    }

}