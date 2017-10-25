package com.yingtaohuo.auth

import com.yingtaohuo.exception.InvalidAuthTokenException
import com.yingtaohuo.props.AppProps
import com.yingtaohuo.props.WeixinProps
import com.yingtaohuo.util.getTelPhoneFromToken
import com.yingtaohuo.util.validateToken
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.util.StringUtils
import java.net.URLEncoder
import java.util.regex.Pattern


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

val authLogger = LoggerFactory.getLogger(AuthTokenAuthenticationTokenFilter::class.java)!!

// filter
open class AuthTokenAuthenticationTokenFilter(
        val appProps: AppProps,
        @Autowired
        @Qualifier("userDetailsService")
        private val userDetailsService: UserDetailsService) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val authorizationOfQuery = request.getParameter("auth_token")
        val authorizationOfHeader = request.getHeader("X-Authorization")

        var authToken = ""

        if (!StringUtils.isEmpty(authorizationOfQuery)) {
            authToken = authorizationOfQuery
        } else if (authorizationOfHeader != null && authorizationOfHeader.startsWith("YTH ") ) {
            authToken = authorizationOfHeader.substring(4)
        }

        if ( !StringUtils.isEmpty(authToken) ) {
            try {
                val telPhone = getTelPhoneFromToken(authToken, appProps.ssoSecret!!)
                if ( SecurityContextHolder.getContext().authentication == null ) {
                    val user = userDetailsService.loadUserByUsername(telPhone) as YTHAuthUser
                    if ( validateToken(authToken, appProps.ssoSecret!!, user) ) {
                        val authentication = UsernamePasswordAuthenticationToken(user, null, user.authorities)
                        authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                        authLogger.info("authenticated user $telPhone, setting security context")
                        SecurityContextHolder.getContext().authentication = authentication
                    }
                }
            } catch (ex : Throwable) {
                if (authLogger.isInfoEnabled) {
                    authLogger.info("auth token format error", ex)
                }
                // 不正确的 auth_token
                throw InvalidAuthTokenException("auth token $authToken", ex)
            }
        } else {
            if ( authLogger.isDebugEnabled ) {
                authLogger.debug("spring security - filter auth token not in request headers")
            }
        }
        filterChain.doFilter(request, response)
    }
}

class AuthAccessDeniedHandler : AccessDeniedHandler {

    override fun handle(request: HttpServletRequest, response: HttpServletResponse, deniedException: AccessDeniedException) {
        deniedException.printStackTrace()
    }

}

// entry_point
class AuthAuthenticationEntryPoint(private val appProps : AppProps, private val wxProps: WeixinProps) : AuthenticationEntryPoint {

    private val WeixinAuthorizeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect"

    private val PcLoginUrl = appProps.siteUrl + "/auth/login"

    override fun commence(request: HttpServletRequest, response: HttpServletResponse, authException: AuthenticationException) {
        val ua = request.getHeader("User-Agent")
        val fromUrl = request.requestURL.toString()
        val ythUa = Pattern.compile("YTH_")
        val wxUa = Pattern.compile("MicroMessenger")
        when ( true ) {
            // 如果在樱桃火App内打开
            ythUa.matcher(ua).find() -> {
                authLogger.debug("================= in yth app =================")
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.message)
            }
            // 如果在微信中打开
            wxUa.matcher(ua).find() -> {
                if (wxUa.matcher(ua).find()) {
                    authLogger.debug("================= in weixin =================")
                    val encodeUrl = URLEncoder.encode(fromUrl, "UTF-8")
                    val redUrl = WeixinAuthorizeUrl
                            .replace("APPID", wxProps.serviceNo.appId, true)
                            .replace("REDIRECT_URI", encodeUrl, true)
                            .replace("SCOPE", "snsapi_base")
                            .replace("STATE", "ythauth")
                    response.sendRedirect(redUrl)
                }
            }
            else -> {
                response.sendRedirect(PcLoginUrl)
            }
        }
    }
}

