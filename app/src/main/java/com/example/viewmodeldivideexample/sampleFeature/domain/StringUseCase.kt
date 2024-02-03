package com.example.viewmodeldivideexample.sampleFeature.domain

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StringUseCase {

    suspend fun invoke(): Flow<String> {
        var x = 0

        return flow {
            while (true) {
                x+=1
                emit(x.toString())
                delay(1000)
            }
        }
    }
}