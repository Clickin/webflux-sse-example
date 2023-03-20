package com.example.webfluxsse

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebFluxSSEExampleApplication

fun main(args: Array<String>) {
    runApplication<WebFluxSSEExampleApplication>(*args)
}
