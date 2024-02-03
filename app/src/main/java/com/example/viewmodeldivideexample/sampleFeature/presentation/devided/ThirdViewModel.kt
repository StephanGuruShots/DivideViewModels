package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class ThirdViewModel @Inject constructor() : AppViewModel(DeleteObj.container) {

    init {
        doIntent {
            while (true) {
                delay(1500)
                Log.d("rawr", "${state}")
            }
        }
    }

    fun sendAction(action: Action) {
        when (action) {
            Action.Button3Clicked -> {
                doIntent {
                    doReduce(
                        state.copy(
                            buttonText = state.text3
                        )
                    )
                    doPostSideEffect(SideEffect.Notify3ButtonClicked)
                }
            }

            else -> {

            }
        }
    }
}