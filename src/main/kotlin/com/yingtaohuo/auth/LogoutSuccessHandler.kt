package com.yingtaohuo.auth

import org.springframework.security.web.authentication.logout.LogoutSuccessHandler
import javax.servlet.http.HttpServletResponse
import java.util.HashMap
import javax.servlet.ServletException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.core.Authentication
import java.io.IOException
import javax.servlet.http.HttpServletRequest


/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/14
 * 微信: yin80871901
 */
class LogoutSuccess(private val objectMapper: ObjectMapper) : LogoutSuccessHandler {

    @Throws(IOException::class, ServletException::class)
    override fun onLogoutSuccess(httpServletRequest: HttpServletRequest, response: HttpServletResponse, authentication: Authentication?) {
        val result = HashMap<String, String>()
        result.put("result", "success")
        response.contentType = "application/json"
        response.writer.write(objectMapper.writeValueAsString(result))
        response.status = HttpServletResponse.SC_OK
    }

}