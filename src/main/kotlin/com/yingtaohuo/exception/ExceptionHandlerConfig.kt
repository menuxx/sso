package com.yingtaohuo.exception

import com.fasterxml.jackson.databind.exc.InvalidFormatException
import com.yingtaohuo.resp.RespData
import org.jooq.exception.DataAccessException
import org.slf4j.LoggerFactory
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/28
 * 微信: yin80871901
 */
@ControllerAdvice
class ExceptionHandlerConfig {

    val logger = LoggerFactory.getLogger(ExceptionHandlerConfig::class.java)!!

    @ExceptionHandler(NotFoundException::class)
    @ResponseBody
    fun notFound(ex: NotFoundException) : RespData<Any> {
        logger.error("not found", ex)
        return RespData(null).failed(ex.message ?: "not found", 102)
    }

    @ExceptionHandler(InvalidAuthTokenException::class)
    @ResponseBody
    fun authToken(ex: InvalidAuthTokenException) : RespData<Any> {
        logger.error("invalid auth token", ex)
        return RespData(null).failed(ex.message ?: "invalid auth token", 101)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class, InvalidParameterException::class, InvalidFormatException::class)
    @ResponseBody
    fun invalidParam(ex: HttpMessageNotReadableException) : RespData<Any> {
        logger.error("invalid params", ex)
        return RespData(null).failed("invalid params", 104)
    }

    @ExceptionHandler(DataAccessException::class)
    @ResponseBody
    fun dbException(ex: DataAccessException) : RespData<Any> {
        logger.error("database access exception sqlstate : ${ex.sqlState()}", ex)
        return RespData(null).failed(ex.message ?: "database access exception", 103)
    }

}