package com.yingtaohuo.wechat

import feign.Headers
import feign.Param
import feign.RequestLine

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/17
 * 微信: yin80871901
 */

/**
 * baseUrl https://api.weixin.qq.com/
 */
@Headers("Accept: application/json", "Content-Type: application/json")
interface WXCommonApi {

    @RequestLine("GET /cgi-bin/token?grant_type=client_credential&appid={appId}&secret={appSecret}")
    @Throws(WXException::class)
    fun getAccessToken(@Param("appId") appId: String, @Param("appSecret") appSecret: String) : WXAccessToken

}

/**
 * baseUrl https://api.weixin.qq.com/
 */
@Headers("Accept: application/json", "Content-Type: application/json")
interface WXUserApi {

    /**
     * 获取 accessToken
     */
    @RequestLine("GET /sns/oauth2/access_token?appid={appId}&secret={appSecret}&code={code}&grant_type=authorization_code")
    @Throws(WXException::class)
    fun getAccessToken(@Param("appId") appId: String, @Param("appSecret") appSecret: String, @Param("code") code: String) : WXUserAccessToken

    /**
     * 使用刷新令牌获取用户身份信息
     */
    @RequestLine("GET /sns/oauth2/refresh_token?appid={appId}&grant_type=refresh_token&refresh_token={refreshToken}")
    @Throws(WXException::class)
    fun refreshToken(@Param("appId") appId: String, @Param("refreshToken") refreshToken: String) : WXUserAccessToken

    /**
     * 获取用户信息
     */
    data class UserInfoQuery(val accessToken: String, val openid: String)
    @RequestLine("GET /sns/userinfo?access_token={accessToken}&openid={openid}&lang=zh_CN")
    @Throws(WXException::class)
    fun getUserInfo(@Param("accessToken") accessToken: String, @Param("openid") openid: String) : WXUserInfo

    /**
     * 验证 accessToken
     */
    @RequestLine("GET /sns/auth?access_token={accessToken}&openid={openid}")
    @Throws(WXException::class)
    fun verifyAccessToken(@Param("accessToken") accessToken: String, @Param("openid") openid: String) : WXResult

}

