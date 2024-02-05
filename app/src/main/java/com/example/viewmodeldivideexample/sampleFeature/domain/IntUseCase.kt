package com.example.viewmodeldivideexample.sampleFeature.domain

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class IntUseCase {

    suspend fun invoke(): Int {
        return Random.nextInt(0,100)
    }
}