package com.yingtaohuo.routes

import com.yingtaohuo.AllOpen
import com.yingtaohuo.resp.RespData
import com.yingtaohuo.service.CaptchaService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/18
 * 微信: yin80871901
 */
@AllOpen
@RestController
@RequestMapping("/captcha")
class CaptchaRoute(val captchaService: CaptchaService) {

    data class SendCaptcha(val mobile: String)
    @PostMapping("/send")
    fun sendCaptcha(@Valid @RequestBody captcha: SendCaptcha) : RespData<String> {
        return try {
            val captcha = captchaService.sendCaptcha(captcha.mobile)
            RespData("ok").success()
        } catch (ex: Exception) {
            RespData(ex.message).failed("短信发送失败", 5001)
        }
    }

}