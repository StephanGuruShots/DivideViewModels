package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.viewmodeldivideexample.sampleFeature.domain.StringUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class ThirdViewModelImpl @Inject constructor(
    private val appViewModel: AppViewModel,
    private val sharedUseCases: SharedUseCases
) : AppViewModel by appViewModel, ViewModel() {

    init {

    }

    fun sendAction(action: AppViewModelImpl.Action) {
        when (action) {
            AppViewModelImpl.Action.Button3Clicked -> {
                doIntent {
                    doReduce { state ->
                        state.copy(
                            buttonText = state.text3
                        )
                    }

                    doPostSideEffect(AppViewModelImpl.SideEffect.Notify3ButtonClicked)
                }
            }

            AppViewModelImpl.Action.IntButtonClicked -> {
                doIntent {
                    sharedUseCases.invokeIntUseCase()
                    sharedUseCases.intSharedFlow.collect {
                        doReduce { state ->
                            state.copy(intValue = it.toString())
                        }
                    }
                }
            }

            else -> {

            }
        }
    }
}