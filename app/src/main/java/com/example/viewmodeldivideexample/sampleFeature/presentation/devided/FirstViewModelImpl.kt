package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import javax.inject.Inject

class FirstViewModelImpl @Inject constructor(
    private val sharedUseCases: SharedUseCases,
) : AppViewModel{

    private lateinit var parent: AppViewModel

    override fun init(parent: AppViewModel) {
        this.parent = parent

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

    override fun doIntent(work: suspend () -> Unit) {
        parent.doIntent(work)
    }

    override fun doReduce(invoke: (state: AppViewModelImpl.State) -> AppViewModelImpl.State) {
        parent.doReduce(invoke)
    }

    override fun doPostSideEffect(sideEffect: AppViewModelImpl.SideEffect) {
        parent.doPostSideEffect(sideEffect)
    }
}