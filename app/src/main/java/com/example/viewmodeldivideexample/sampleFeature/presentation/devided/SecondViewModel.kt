package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import com.example.viewmodeldivideexample.sampleFeature.domain.StringUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    private val stringUseCase: StringUseCase
) : AppViewModel(DeleteObj.container) {

    init {
        doIntent {
            stringUseCase.invoke().collect {
                doReduce(
                    state.copy(text2 = it)
                )
            }
        }
    }

    fun sendAction(action: Action) {
        when (action) {
            Action.Button2Clicked -> {
                doIntent {
                    doReduce(
                        state.copy(
                            buttonText = state.text2
                        )
                    )
                    doPostSideEffect(SideEffect.Notify2ButtonClicked)
                }
            }

            else -> {}
        }
    }
}