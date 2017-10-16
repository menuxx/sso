package com.yingtaohuo.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.yingtaohuo.AllOpen
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/10/16
 * 微信: yin80871901
 */
@AllOpen
@Configuration
class RedisConfig {

    @Bean
    internal fun jackson2JsonRedisSerializer(objectMapper: ObjectMapper): Jackson2JsonRedisSerializer<Any> {
        val jackson2JsonRedisSerializer = Jackson2JsonRedisSerializer(Any::class.java)
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper)
        return jackson2JsonRedisSerializer
    }

    @Bean("redisTemplate")
    fun objRedisTemplate(connectionFactory: RedisConnectionFactory, jackson2JsonRedisSerializer: Jackson2JsonRedisSerializer<Any>): RedisTemplate<String, Any> {
        val redisTemplate = RedisTemplate<String, Any>()
        redisTemplate.connectionFactory = connectionFactory
        redisTemplate.defaultSerializer = jackson2JsonRedisSerializer
        val stringRedisSerializer = StringRedisSerializer()
        redisTemplate.keySerializer = stringRedisSerializer
        redisTemplate.hashKeySerializer = stringRedisSerializer
        return redisTemplate
    }

}