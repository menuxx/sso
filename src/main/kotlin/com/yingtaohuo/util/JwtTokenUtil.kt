package com.yingtaohuo.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.yingtaohuo.NoArg
import com.yingtaohuo.auth.YTHAuthUser
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.Claims
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/27
 * 微信: yin80871901
 */

fun genAuthToken(telPhone: String, secret: String) : String {
    val createdDate = Date()
    val expirationDate = Date(Date().toInstant().plusSeconds(7200 * 4).toEpochMilli())

    val subject = telPhone
    val expireTime = expirationDate.time / 1000
    val audience = 7

    val claims = mapOf("sub" to subject, "aud" to audience, "exp" to expireTime)

    return Jwts.builder()
            .setClaims(claims)
            .setSubject(subject)
            .setAudience(audience.toString())
            .setIssuedAt(createdDate)
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact()
}

fun getTelPhoneFromToken(token: String, secret: String) : String? {
    return getAllClaimsFromToken(token, secret).subject
}

fun getIssuedAtDateFromToken(token: String, secret: String) : Date {
    return getAllClaimsFromToken(token, secret).issuedAt
}

fun getExpirationDateFromToken(token: String, secret: String) : Date {
    return getAllClaimsFromToken(token, secret).expiration
}

fun getAllClaimsFromToken(token: String, secret: String): Claims {
    return Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .body
}

@NoArg
data class JwtPayload(val sub: String, val aud: String, val exp: Int, val iat: String)

private val objectMapper = ObjectMapper().registerModule(KotlinModule())

fun parseBody(token: String) : JwtPayload {
    val paylod = token.split(".")[1]
    val body = Base64.getDecoder().decode(paylod.toByteArray())
    return objectMapper.readValue<JwtPayload>(body, JwtPayload::class.java)
}

fun getJwtSubject(token: String) = parseBody(token).sub

fun getJwtAudience(token: String) = parseBody(token).aud

fun isTokenExpired(token: String, secret: String) = getExpirationDateFromToken(token, secret).before(Date())

// https://github.com/szerhusenBC/jwt-spring-security-demo/blob/master/src/main/java/org/zerhusen/security/JwtTokenUtil.java
fun validateToken(token: String, secret: String, authUser: YTHAuthUser) : Boolean {
    val telphone = getTelPhoneFromToken(token, secret)
    // val issuedAt = getIssuedAtDateFromToken(token, secret)
    return authUser.telphone == telphone && !isTokenExpired(token, secret)
}