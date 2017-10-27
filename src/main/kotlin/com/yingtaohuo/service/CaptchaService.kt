package com.yingtaohuo.service

import com.yingtaohuo.props.RongLianProps
import com.yingtaohuo.ronglian.SmsClient
import com.yingtaohuo.ronglian.SmsException
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/27
 * 微信: yin80871901
 */
@Service
class CaptchaService(
        private val redisTemplate: RedisTemplate<String, String>,
        val rongLianProps: RongLianProps
) {

    private val CAPTCHA_ID = "198719"

    private val smsClient = SmsClient(rongLianProps.appId, rongLianProps.accountSid, rongLianProps.authToken)

    fun nextInt(min: Int, max: Int) : Int {
        val rand = Random()
        val tmp = Math.abs(rand.nextInt())
        return tmp % (max - min + 1) + min
    }

    fun generateCaptcha(): String {
        return String.format("%04d", nextInt(0, 9999))
    }

    @Throws(SmsException::class)
    fun sendCaptcha(mobile: String) : String {
        val captcha = generateCaptcha()
        val json = smsClient.sendSms(mobile, CAPTCHA_ID, arrayOf(captcha))
        if ( json.getString("statusCode") == "000000" ) {
            setCaptcha(mobile, captcha)
            return captcha
        }
        throw RuntimeException("验证码发送失败: $json")
    }

    fun setCaptcha(mobile: String, captcha: String) {
        return redisTemplate.opsForValue().set("captcha:$mobile", captcha)
    }

    fun getCaptcha(mobile: String) : String? {
        return redisTemplate.opsForValue().get("captcha:$mobile")
    }

}