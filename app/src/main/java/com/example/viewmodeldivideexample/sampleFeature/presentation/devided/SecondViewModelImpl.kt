package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.viewmodeldivideexample.sampleFeature.domain.StringUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class SecondViewModelImpl @Inject constructor(
    private val sharedUseCases: SharedUseCases
) : AppViewModel() {

    override fun init(parent: AppViewModelImpl) {
        super.init(parent)

        Log.d("rawr", "shared uc 1vm = ${sharedUseCases}")
        doIntent {
            sharedUseCases.stringSharedFlow.collect {
                Log.d("rawr", "second vm collect")
                doReduce { state ->
                    state.copy(text2 = it)
                }
            }
        }

        doIntent {
            sharedUseCases.intSharedFlow.collect {
                doReduce { state ->
                    state.copy(text3 = it.toString())
                }
            }
        }
    }

    fun sendAction(action: AppViewModelImpl.Action) {
        when (action) {
            AppViewModelImpl.Action.Button2Clicked -> {
                doIntent {
                    doReduce { state ->
                        state.copy(
                            buttonText = state.text2
                        )
                    }
                    doPostSideEffect(AppViewModelImpl.SideEffect.Notify2ButtonClicked)
                }
            }

            else -> {}
        }
    }
}