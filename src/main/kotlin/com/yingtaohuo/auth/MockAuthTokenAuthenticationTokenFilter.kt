package com.yingtaohuo.auth

import com.yingtaohuo.props.AppProps
import com.yingtaohuo.util.genAuthToken
import org.springframework.security.core.userdetails.UserDetailsService
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper
import javax.servlet.http.HttpServletResponse

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/29
 * 微信: yin80871901
 */

class MockHttpServletRequestWrapper(request: HttpServletRequest?) : HttpServletRequestWrapper(request) {
    override fun getHeader(name: String?): String? {
        return if (name != null && name == "X-Authorization") {
            "YTH " + genAuthToken(telPhone = "13575762817", secret = "1234")
        } else {
            super.getHeader(name)
        }
    }
}

class MockAuthTokenAuthenticationTokenFilter(appProps: AppProps, userDetailsService: UserDetailsService) : AuthTokenAuthenticationTokenFilter(appProps, userDetailsService) {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        super.doFilterInternal(MockHttpServletRequestWrapper(request), response, filterChain)
    }
}