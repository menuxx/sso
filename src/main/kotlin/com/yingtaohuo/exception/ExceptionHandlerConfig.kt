package com.yingtaohuo.exception

import com.yingtaohuo.resp.RespData
import org.jooq.exception.DataAccessException
import org.slf4j.LoggerFactory
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
    fun notFound(ex: NotFoundException) : RespData {
        logger.error("not found", ex)
        return RespData(null).failed("not found", 102)
    }

    @ExceptionHandler(InvalidAuthTokenException::class)
    @ResponseBody
    fun authToken(ex: InvalidAuthTokenException) : RespData {
        logger.error("invalid auth token", ex)
        return RespData(null).failed("invalid auth token", 101)
    }

    @ExceptionHandler(DataAccessException::class)
    fun dbException(ex: DataAccessException) : RespData {
        logger.error("database access exception sqlstate : ${ex.sqlState()}", ex)
        return RespData(null).failed("database access exception", 103)
    }

}