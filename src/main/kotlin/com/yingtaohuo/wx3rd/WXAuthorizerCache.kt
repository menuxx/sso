package com.yingtaohuo.wx3rd

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/15
 * 微信: yin80871901
 */

@Service
class WXAuthorizerCache(
        private val redisTemplate: RedisTemplate<String, Any>
) {

    @SuppressWarnings("unchecked")
    fun getAuthorizerToken(appId: String) : String? {
        val tokens = redisTemplate.opsForValue().get("authorizer_token:$appId") as Map<String, String>
        return tokens["authorizer_access_token"]
    }

    @SuppressWarnings("unchecked")
    fun getComponentToken(appId: String) : String? {
        val tokens = redisTemplate.opsForValue().get("component_token:$appId") as Map<String, String>
        return tokens["component_access_token"]
    }

}