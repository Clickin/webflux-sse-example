package com.example.webfluxsse

import org.springframework.http.codec.ServerSentEvent
import org.springframework.stereotype.Controller
import org.springframework.web.reactive.function.server.*

@Controller
class RandomHandler(
    private val randomService: RandomService
) {

    suspend fun getRandomInt(serverRequest: ServerRequest) : ServerResponse {
        val data = randomService.generateRandomList(10)
        //List<Int>의 ServerSentEvent
        return ServerResponse.ok().sse().bodyValueAndAwait(ServerSentEvent.builder(data).build())
    }

    suspend fun getRandomIntFlow(serverRequest: ServerRequest) : ServerResponse {
        //Flow<Int>가 순차적으로 발생된다
        return ServerResponse.ok().sse().bodyAndAwait(randomService.generateRandomFlow(10))
    }
}