package com.yingtaohuo.wechat

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/17
 * 微信: yin80871901
 */

data class WXAccessToken(
        @JsonProperty("access_token")
        val accessToken: String,
        @JsonProperty("expires_in")
        val expiresIn: Int
)

data class WXUserAccessToken(
        @JsonProperty("access_token")
        val accessToken: String,
        @JsonProperty("expires_in")
        val expiresIn: Int,
        @JsonProperty("refresh_token")
        val refreshToken: String,
        val openid: String,
        val scope: String,
        val unionid: String
)

data class WXResult(val errcode: Int, val errmsg: String)

data class WXUserInfo(
        // 用户的唯一标识
        val openid: String,
        // 用户昵称
        val nickname: String,
        // 	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
        val sex: String,
        // 用户个人资料填写的省份
        val province: String,
        // 普通用户个人资料填写的城市
        val city: String,
        // 国家，如中国为CN
        val country: String,
        // 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效
        val headimgurl: String,
        // 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
        val privilege: Array<String>,
        // 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
        val unionid: String,
        val language: String
)