package com.example.webfluxsse

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class RandomService {

    suspend fun generateRandomList(flowSize: Int): List<Int> {
        return (0 until flowSize).map { generateRandom(0, 100) }
    }

    fun generateRandomFlow(flowSize: Int): Flow<Int> = runBlocking {
        generateRandomList(flowSize).asFlow()
    }

    private fun generateRandom(from: Int, to: Int): Int {
        return Random.nextInt(from, to)
    }
}