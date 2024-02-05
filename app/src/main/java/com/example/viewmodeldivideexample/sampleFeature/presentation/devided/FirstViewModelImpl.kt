package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModelImpl @Inject constructor(
    private val appViewModel: AppViewModel,
    private val sharedUseCases: SharedUseCases
) : AppViewModel by appViewModel, ViewModel() {

    init {
        Log.d("rawr", "shared uc 1vm = ${sharedUseCases}")
        doIntent {
            sharedUseCases.invokeStringUseCase()
        }

        doIntent {
            sharedUseCases.stringSharedFlow.collect {
                Log.d("rawr", "first vm collect")
                doReduce { state ->
                    state.copy(text1 = it)
                }
            }
        }
    }

    fun sendAction(action: AppViewModelImpl.Action) {
        when (action) {
            AppViewModelImpl.Action.Button1Clicked -> {
                doIntent {
                    doReduce { state ->
                        state.copy(
                            buttonText = state.text1
                        )
                    }
                    doPostSideEffect(AppViewModelImpl.SideEffect.Notify1ButtonClicked)
                }
            }

            else -> {}
        }
    }
}