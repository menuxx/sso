package com.yingtaohuo.service

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/27
 * 微信: yin80871901
 */
@Service
class CaptchaService(private val redisTemplate: RedisTemplate<String, String>) {

    fun getCaptcha(telphone: String) : String? {
        return redisTemplate.opsForValue().get("captcha:$telphone")
    }

}