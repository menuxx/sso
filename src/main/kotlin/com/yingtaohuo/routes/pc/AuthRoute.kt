package com.yingtaohuo.routes.pc

import com.yingtaohuo.AllOpen
import com.yingtaohuo.auth.JwtAuthenticationRequest
import com.yingtaohuo.auth.TokenHelper
import com.yingtaohuo.auth.YTHAuthUser
import com.yingtaohuo.db.DBShopUser
import com.yingtaohuo.exception.NotFoundException
import com.yingtaohuo.mode.UserTokenState
import com.yingtaohuo.model.CategoryModel
import com.yingtaohuo.resp.RespData
import com.yingtaohuo.resp.RespMeta
import com.yingtaohuo.util.getCurrentUser
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.mobile.device.Device
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.AuthenticationException
import org.springframework.ui.Model
import java.io.IOException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import javax.servlet.http.Cookie
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid
import kotlin.collections.HashMap


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/10
 * 微信: yin80871901
 */
@AllOpen
@Controller
@RequestMapping("/auth")
class AuthRoute(
        private val authenticationManager: AuthenticationManager,
        val dbShopUser: DBShopUser,
        val userDetailsService: UserDetailsService
) {

    @GetMapping("/login")
    fun loginView(model: Model) : String {
        model.addAttribute("title", "管理登录")
        return "pc/login"
    }

    @PostMapping("/login")
    @Throws(AuthenticationException::class, IOException::class)
    fun loginAction(@Valid @RequestBody authenticationRequest: JwtAuthenticationRequest, response: HttpServletResponse, device: Device) : ResponseEntity<*> {
        val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        authenticationRequest.mobile,
                        authenticationRequest.password
                )
        )
        val user = authentication.principal as YTHAuthUser
        val jws = TokenHelper.generateToken(user.username, device)
        response.addCookie( createAuthCookie( jws, TokenHelper.EXPIRES_IN ) )
        return ResponseEntity.ok(UserTokenState(jws, TokenHelper.EXPIRES_IN ))
    }

    // 管理员切换店铺
    data class BindShop(@NotEmpty val shopId: Int)
    @PutMapping("/bind_shop")
    @ResponseBody
    fun adminBindShop(@Valid @RequestBody shop: BindShop, request: HttpServletRequest) : RespData<String> {
        val admin = getCurrentUser()
        admin.shopId = shop.shopId
        val authentication = UsernamePasswordAuthenticationToken(admin, null, admin.authorities)
        authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
        SecurityContextHolder.getContext().authentication = authentication
        return RespData("ok").success()
    }

    @GetMapping("/refresh")
    fun refreshAuthenticationToken(request: HttpServletRequest, response: HttpServletResponse
    ): ResponseEntity<*> {
        val authToken = TokenHelper.getToken(request)
        return if (authToken != null && TokenHelper.canTokenBeRefreshed(authToken)) {
            // TODO check user password last update
            val refreshedToken = TokenHelper.refreshToken(authToken)
            // Add cookie to response
            response.addCookie(createAuthCookie(refreshedToken!!, TokenHelper.EXPIRES_IN))
            ResponseEntity.ok(UserTokenState(refreshedToken, TokenHelper.EXPIRES_IN))
        } else {
            ResponseEntity.accepted().body(RespMeta("未获取过刷新令牌", -1, null))
        }
    }

    private fun createAuthCookie(jwt: String, expiresIn: Int): Cookie {
        val authCookie = Cookie(TokenHelper.AUTH_COOKIE, jwt)
        authCookie.path = "/"
        authCookie.isHttpOnly = true
        authCookie.maxAge = expiresIn
        return authCookie
    }

    fun genAuthToken(mobile: String, userId: Int) : String {
        // token 创建时间
        val createdDate = Date()
        // token 过期时间
        val expirationDate = Date(Date().time + (7200 * 1000))

        // 以用户手机作为 签名主字段
        val subject = mobile
        // 以用户id作为 签名附字段
        val audience = userId
        val expireTime = expirationDate.time / 1000

        val claims = mapOf("sub" to subject, "aud" to audience, "exp" to expireTime)

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setAudience(audience.toString())
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, TokenHelper.SECRET)
                .compact()
    }

    data class AuthToken(val authToken: String)
    @GetMapping("/token")
    @ResponseBody
    fun authToken(@RequestParam("shop_id") shopId: Int) : AuthToken {
        val users = dbShopUser.loadUsersByShopId(shopId)
        if ( users.isNotEmpty() ) {
            val user = users.first()
            val authToken = genAuthToken(user.mobile, user.id.toInt())
            return AuthToken(authToken)
        }
        throw NotFoundException("该商户没有任何管理员")
    }

}