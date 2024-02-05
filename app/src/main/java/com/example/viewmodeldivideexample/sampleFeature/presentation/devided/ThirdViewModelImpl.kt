package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.viewmodeldivideexample.sampleFeature.domain.StringUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class ThirdViewModelImpl @Inject constructor(
    private val sharedUseCases: SharedUseCases
) : AppViewModel {

    private lateinit var parent: AppViewModel

    override fun init(parent: AppViewModel) {
        this.parent = parent
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