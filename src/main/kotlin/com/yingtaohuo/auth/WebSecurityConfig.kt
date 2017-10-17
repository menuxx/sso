package com.yingtaohuo.auth

import com.fasterxml.jackson.databind.ObjectMapper
import com.yingtaohuo.props.AppProps
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.core.annotation.Order
import org.springframework.core.env.Environment
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/26
 * 微信: yin80871901
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig(
        private val appProps: AppProps,
        private val userService: YTHUserDetailsService,
        private val adminService: YTHAdminDetailsService,
        private val env: Environment,
        private val objectMapper: ObjectMapper
) : WebSecurityConfigurerAdapter() {

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
                HttpMethod.GET,
                "/auth/**",
                "/*.html",
                "/favicon.ico",
                "/**/*.html",
                "/**/*.css",
                "/**/*.txt",
                "/**/*.js"
        );
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

        http
                // .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS ).and()

                // .anonymous().disable()

                .csrf().disable()

                .exceptionHandling()
                    .authenticationEntryPoint(AuthAuthenticationEntryPoint())
                .and()

                .authorizeRequests()

                .antMatchers(
                        HttpMethod.GET,
                        "/auth/**",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.txt",
                        "/**/*.js"
                ).permitAll()

                // .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                .antMatchers("/auth/**").permitAll()

                .anyRequest().authenticated().and()

                .addFilterBefore(TokenAuthenticationFilter(adminService), UsernamePasswordAuthenticationFilter::class.java)
                .addFilterBefore(AuthTokenAuthenticationTokenFilter(appProps, userService), UsernamePasswordAuthenticationFilter::class.java)

                .logout()
                .logoutRequestMatcher(AntPathRequestMatcher("/auth/logout"))
                .logoutSuccessHandler(LogoutSuccess(objectMapper))
                .deleteCookies(TokenHelper.AUTH_COOKIE)


        //if ( env.activeProfiles.contains("development") ) {
        //  .addFilterBefore(MockAuthTokenAuthenticationTokenFilter(appProps, userService), UsernamePasswordAuthenticationFilter::class.java)
        //} else {

        //}

        // http.csrf().disable()
                // .ignoringAntMatchers("/auth/login")
                // .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())


        // http.authorizeRequests().antMatchers(HttpMethod.POST, "/auth/login").authenticated()

        http.headers().cacheControl()
    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(builder: AuthenticationManagerBuilder) {
        builder.userDetailsService(adminService).passwordEncoder(BCryptPasswordEncoder())
    }

}