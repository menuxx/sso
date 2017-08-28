package com.yingtaohuo.auth

import com.yingtaohuo.db.DBShopUser
import com.yingtaohuo.util.getJwtAudience
import com.yingtaohuo.util.getTelPhoneFromToken
import com.yingtaohuo.util.validateToken
import org.slf4j.LoggerFactory
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource





/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/27
 * 微信: yin80871901
 *
 * 在 app 的 webview 中打开网页使用 auth token
 * 读取策略使用 header
 * Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ
 * token 生成机制使用 jwt 实现
 */

typealias InvalidAuthTokenException = java.lang.RuntimeException

val authTokenLogger = LoggerFactory.getLogger(AuthTokenAuthenticationTokenFilter::class.java)!!

// filter
class AuthTokenAuthenticationTokenFilter(
        private val userDetailsService: UserDetailsService,
        private val dbShopUser: DBShopUser) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val authorizationOfHeader = request.getHeader("Authorization")
        if (authorizationOfHeader != null && authorizationOfHeader.startsWith("Bearer ")) {
            val authToken = authorizationOfHeader.substring(7)
            try {
                val audience = getJwtAudience(authToken).toInt()
                val user1 = dbShopUser.getUserById(audience)
                val telPhone = getTelPhoneFromToken(authToken, user1.secret)
                if ( SecurityContextHolder.getContext().authentication == null ) {
                    val user2 = userDetailsService.loadUserByUsername(telPhone) as YTHAuthUser
                    if ( validateToken(authToken, user1.secret, user2) ) {
                        val authentication = UsernamePasswordAuthenticationToken(user2, null, user2.authorities)
                        authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                        authTokenLogger.info("authenticated user $telPhone, setting security context")
                        SecurityContextHolder.getContext().authentication = authentication
                    }
                }
            } catch (ex : Throwable) {
                if (authTokenLogger.isInfoEnabled) {
                    authTokenLogger.info("auth token format error", ex)
                }
                // 不正确的 auth_token
                throw InvalidAuthTokenException()
            }
        } else {
            if ( authTokenLogger.isDebugEnabled ) {
                authTokenLogger.debug("spring security - filter auth token not in request headers")
            }
        }
        filterChain.doFilter(request, response)
    }
}

// entry_point
class AuthTokenAuthenticationEntryPoint : AuthenticationEntryPoint {
    override fun commence(request: HttpServletRequest, response: HttpServletResponse, authException: AuthenticationException) {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
    }
}
