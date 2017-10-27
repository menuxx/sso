package com.yingtaohuo.routes

import com.yingtaohuo.AllOpen
import com.yingtaohuo.db.DBShopUser
import com.yingtaohuo.db.DBWXUser
import com.yingtaohuo.exception.NotFoundException
import com.yingtaohuo.model.WXUserModel
import com.yingtaohuo.resp.RespData
import com.yingtaohuo.service.CaptchaService
import com.yingtaohuo.wechat.WXUserInfo
import org.hibernate.validator.constraints.NotEmpty
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.HttpSession
import javax.validation.Valid

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/17
 * 微信: yin80871901
 */
@AllOpen
@RequestMapping("/auth/wx")
@Controller
class WeixinRoute(
        private val captchaService: CaptchaService,
        private val dbShopUser: DBShopUser,
        private val dbWXUser: DBWXUser
) {

    @GetMapping("/shop_bind")
    fun shopBindView(model: Model, session: HttpSession) : String {
        model.addAttribute("title", "商户店铺绑定")
        val authUserInfo = session.getAttribute("authUserInfo") as WXUserInfo
        model.addAttribute("authUserInfo", authUserInfo)
        return "mobile/shop_bind"
    }

    data class ShopBind(
            @NotEmpty val mobile: String,
            @NotEmpty val captcha: String
    )

    @PostMapping("/shop_bind")
    @ResponseBody
    fun shopBindAction(@Valid @RequestBody shopBind: ShopBind, session: HttpSession) : RespData<String> {
        val captcha = captchaService.getCaptcha(shopBind.mobile)
        val authUserInfo = session.getAttribute("authUserInfo") as WXUserInfo?
        if ( StringUtils.isEmpty(captcha) || captcha != shopBind.captcha ) {
            return RespData("验证码不正确，再发一次吧").failed("验证码不正确", 4001)
        }
        if ( authUserInfo?.unionid != null ) {
            val user = dbWXUser.findUserByUnionid(authUserInfo.unionid)
            val userModel = WXUserModel()
            userModel.unionid = authUserInfo.unionid
            userModel.city = authUserInfo.city
            userModel.country = authUserInfo.country
            userModel.headimgurl = authUserInfo.headimgurl
            userModel.updateAt = Date()
            userModel.nickname = authUserInfo.nickname
            userModel.openid = authUserInfo.openid
            userModel.province = authUserInfo.province
            userModel.sex = authUserInfo.sex.toInt()
            val wxUser = if ( user == null ) {
                dbWXUser.insertUser(userModel)
            } else {
                dbWXUser.updateUser(userModel)
            }
            dbShopUser.updateWxUserId(shopBind.mobile, wxUser.id.toInt())
            return RespData("ok").success()
        }
        throw NotFoundException("还没有通过微信认证授权")
    }

}