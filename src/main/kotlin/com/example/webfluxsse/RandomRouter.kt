package com.example.webfluxsse

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter


@Configuration
class RandomRouter {
    @Bean
    fun randomEndpoint(randomHandler: RandomHandler) =
        // suspend fun을 Handler로 등록하기 위해서는 coRouter가 필요
    coRouter {
        GET("/randomInt", randomHandler::getRandomInt)
        GET("/randomIntFlow", randomHandler::getRandomIntFlow)
    }

}