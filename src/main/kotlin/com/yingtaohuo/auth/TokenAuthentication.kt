package com.yingtaohuo.auth

import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import javax.servlet.ServletException
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletResponse
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import org.springframework.security.authentication.AbstractAuthenticationToken




/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/14
 * 微信: yin80871901
 */

class TokenBasedAuthentication(private val principle: UserDetails) : AbstractAuthenticationToken(principle.authorities) {

    var token: String? = null

    override fun isAuthenticated() = true

    override fun getCredentials() = token

    override fun getPrincipal() = principle
}

class TokenAuthenticationFilter(private val userDetailsService: UserDetailsService) : OncePerRequestFilter() {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Throws(IOException::class, ServletException::class)
    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            chain: FilterChain
    ) {

        val auth = SecurityContextHolder.getContext().authentication

        if ( auth == null || !auth.isAuthenticated ) {
            val authToken = TokenHelper.getToken(request)

            if (authToken != null) {
                // get username from token
                val username = TokenHelper.getUsernameFromToken(authToken)
                if (username != null) {
                    // get user
                    val userDetails = userDetailsService.loadUserByUsername(username)
                    if (TokenHelper.validateToken(authToken, userDetails)) {
                        // create authentication
                        val authentication = TokenBasedAuthentication(userDetails)
                        authentication.token = authToken
                        SecurityContextHolder.getContext().authentication = authentication
                    }
                }
            }
        }

        chain.doFilter(request, response)

    }

}