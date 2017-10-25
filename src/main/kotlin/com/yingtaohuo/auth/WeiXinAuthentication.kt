package com.yingtaohuo.auth

import com.yingtaohuo.db.DBShopUser
import com.yingtaohuo.db.DBWXUser
import com.yingtaohuo.props.WeixinProps
import com.yingtaohuo.wechat.WXUserApi
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/17
 * 微信: yin80871901
 */

open class WeiXinAuthenticationFilter(
        private val wxUserApi: WXUserApi,
        private val wxProps: WeixinProps,
        private val dbWXUser: DBWXUser,
        private val dbShopUser: DBShopUser,
        private val userDetailsService: UserDetailsService
) : OncePerRequestFilter() {

    private val myLogger = LoggerFactory.getLogger(WeiXinAuthenticationFilter::class.java)

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filter: FilterChain) {
        val authCode = request.getParameter("code")
        val state = request.getParameter("state")
        if (!StringUtils.isEmpty(authCode) && !StringUtils.isEmpty(state)) {
            if (state == "ythauth") {
                val userToken = wxUserApi.getAccessToken(
                        wxProps.serviceNo.appId, wxProps.serviceNo.appSecret,
                        authCode
                )
                val userInfo = wxUserApi.getUserInfo(userToken.accessToken, userToken.openid)
                val wxUser = dbWXUser.findUserByUnionid(userInfo.unionid)
                // 该用户已授权
                if ( wxUser != null ) {
                    val shopUser = dbShopUser.getUserByWxUserId(wxUser.id.toInt())
                    // 该用户已绑定，开始登陆
                    if (shopUser != null) {
                        val userDetail = userDetailsService.loadUserByUsername(shopUser.mobile) as YTHAuthUser
                        val authentication = UsernamePasswordAuthenticationToken(userDetail, null, userDetail.authorities)
                        authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                        SecurityContextHolder.getContext().authentication = authentication
                        // 登陆完成
                        myLogger.debug("=========== weixin user openid: ${wxUser.openid}, mobile: ${shopUser.mobile} 登陆完成")
                    } else {
                        // 该用户没有绑定
                        request.session.setAttribute("authToken", userToken)
                        request.session.setAttribute("authUserInfo", userInfo)
                        // 跳转到绑定页面
                        response.sendRedirect("/auth/wx/shop_bind")
                        return
                    }
                } else {
                    // 跳转到绑定页面
                    request.session.setAttribute("authToken", userToken)
                    request.session.setAttribute("authUserInfo", userInfo)
                    response.sendRedirect("/auth/wx/shop_bind")
                    return
                }
            }
        }

        filter.doFilter(request, response)

    }

}