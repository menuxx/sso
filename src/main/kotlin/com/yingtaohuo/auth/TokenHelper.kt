package com.yingtaohuo.auth

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.mobile.device.Device
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.Claims
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/14
 * 微信: yin80871901
 */
object TokenHelper {

    const val APP_NAME = "YTH"

    const val SECRET = "eWluZ3Rhb2h1bw=="

    const val EXPIRES_IN = 7200

    const val AUTH_HEADER = "X-Authorization"

    const val AUTH_COOKIE = "auth-token"

    val SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512

    fun getUsernameFromToken(token: String): String? {
        return try {
            val claims = this.getAllClaimsFromToken(token)
            claims!!.subject
        } catch (e: Exception) {
            null
        }
    }

    fun getIssuedAtDateFromToken(token: String): Date? {
        return try {
            val claims = this.getAllClaimsFromToken(token)
            claims!!.issuedAt
        } catch (e: Exception) {
            null
        }
    }

    fun getAudienceFromToken(token: String): String? {
        return try {
            val claims = this.getAllClaimsFromToken(token)
            claims!!.audience
        } catch (e: Exception) {
            null
        }
    }

    fun refreshToken(token: String): String? {
        return try {
            val claims = this.getAllClaimsFromToken(token)
            claims!!.issuedAt = Date()
            Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(generateExpirationDate())
                    .signWith(SIGNATURE_ALGORITHM, SECRET)
                    .compact()
        } catch (e: Exception) {
            null
        }
    }

    fun generateToken(username: String, device: Device): String {
        val audience = generateAudience(device)
        return Jwts.builder()
                .setIssuer(APP_NAME)
                .setSubject(username)
                .setAudience(audience)
                .setIssuedAt(Date())
                .setExpiration(generateExpirationDate())
                .signWith(SIGNATURE_ALGORITHM, SECRET)
                .compact()
    }

    private fun generateAudience(device: Device): String {
        return when(true) {
            device.isNormal -> AUDIENCE_WEB
            device.isTablet -> AUDIENCE_TABLET
            device.isMobile -> AUDIENCE_MOBILE
            else -> AUDIENCE_UNKNOWN
        }
    }

    private fun getAllClaimsFromToken(token: String): Claims? {
        return try {
            Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .body
        } catch (e: Exception) {
            null
        }
    }

    private fun generateExpirationDate(): Date {
        return Date(Date().time + EXPIRES_IN * 1000)
    }

    fun canTokenBeRefreshed(token: String): Boolean {
        val created = getIssuedAtDateFromToken(token)
        return created != null
    }

    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        val username = getUsernameFromToken(token)
        // final Date created = getIssuedAtDateFromToken(token)
        return username != null && username == userDetails.username // && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate())
    }

    fun getToken(request: HttpServletRequest): String? {
        /**
         * Getting the token from Cookie store
         */
        val authCookie = getCookieValueByName(request, AUTH_COOKIE)
        if (authCookie != null) {
            return authCookie.value
        }
        /**
         * Getting the token from Authentication header
         * e.g Bearer your_token
         */
        val authHeader = request.getHeader(AUTH_HEADER)
        return if (authHeader != null && authHeader.startsWith("YTH-ADMIN ")) {
            authHeader.substring(4)
        } else null

    }

    /**
     * Find a specific HTTP cookie in a request.
     *
     * @param request
     * The HTTP request object.
     * @param name
     * The cookie name to look for.
     * @return The cookie, or `null` if not found.
     */
    fun getCookieValueByName(request: HttpServletRequest, name: String?): Cookie? {
        if (request.cookies == null) {
            return null
        }
        for (i in 0 until request.cookies.size) {
            if (request.cookies[i].name == name) {
                return request.cookies[i]
            }
        }
        return null
    }

    const val AUDIENCE_UNKNOWN = "unknown"
    const val AUDIENCE_WEB = "web"
    const val AUDIENCE_MOBILE = "mobile"
    const val AUDIENCE_TABLET = "tablet"
}