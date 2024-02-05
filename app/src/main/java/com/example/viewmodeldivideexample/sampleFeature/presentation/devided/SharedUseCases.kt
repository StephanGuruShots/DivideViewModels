package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import android.util.Log
import com.example.viewmodeldivideexample.sampleFeature.domain.IntUseCase
import com.example.viewmodeldivideexample.sampleFeature.domain.StringUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect

class SharedUseCases(
    private val stringUseCase: StringUseCase,
    private val intUseCase: IntUseCase
) {

    private val _stringSharedFlow =
        MutableSharedFlow<String>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val stringSharedFlow = _stringSharedFlow.asSharedFlow()

    private val _intSharedFlow =
        MutableSharedFlow<Int>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val intSharedFlow = _intSharedFlow.asSharedFlow()

    suspend fun invokeStringUseCase() {
        stringUseCase.invoke().collect() {
            _stringSharedFlow.tryEmit(it)
        }
    }

    suspend fun invokeIntUseCase() {
        _intSharedFlow.tryEmit(intUseCase.invoke())
    }
}