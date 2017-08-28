package com.yingtaohuo.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/28
 * 微信: yin80871901
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
class InvalidAuthTokenException(message: String?, cause: Throwable?) : java.lang.RuntimeException(message, cause)

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(message: String?) : RuntimeException(message)