package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import com.example.viewmodeldivideexample.sampleFeature.domain.StringUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val stringUseCase: StringUseCase
) : AppViewModel(DeleteObj.container) {

    init {
        doIntent {
            stringUseCase.invoke().collect {
                doReduce(
                    state.copy(text1 = it)
                )
            }
        }
    }

    fun sendAction(action: Action) {
        when (action) {
            Action.Button1Clicked -> {
                doIntent {
                    doReduce(
                        state.copy(
                            buttonText = state.text1
                        )
                    )
                    doPostSideEffect(SideEffect.Notify1ButtonClicked)
                }
            }

            else -> {}
        }
    }
}