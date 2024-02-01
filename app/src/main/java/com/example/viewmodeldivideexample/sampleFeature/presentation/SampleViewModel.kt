package com.example.viewmodeldivideexample.sampleFeature.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor() : ViewModel(),
    ContainerHost<SampleViewModel.State, SampleViewModel.SideEffect> {

    override val container: Container<State, SideEffect> = container(State())

    fun sendAction(action: Action) {
        when (action) {
            Action.Button1Clicked -> {
                intent {
                    reduce {
                        state.copy(
                            buttonText = state.text1
                        )
                    }
                    postSideEffect(SideEffect.Notify1ButtonClicked)
                }
            }

            Action.Button2Clicked -> {
                intent {
                    reduce {
                        state.copy(
                            buttonText = state.text2
                        )
                    }
                    postSideEffect(SideEffect.Notify2ButtonClicked)
                }
            }

            Action.Button3Clicked -> {
                intent {
                    reduce {
                        state.copy(
                            buttonText = state.text3
                        )
                    }
                    postSideEffect(SideEffect.Notify3ButtonClicked)
                }
            }
        }
    }

    data class State(
        val text1: String = "text1",
        val text2: String = "text2",
        val text3: String = "text3",
        val buttonText: String = "empty"
    )

    sealed class Action {
        data object Button1Clicked : Action()
        data object Button2Clicked : Action()
        data object Button3Clicked : Action()
    }

    sealed class SideEffect {
        data object Notify1ButtonClicked : SideEffect()
        data object Notify2ButtonClicked : SideEffect()
        data object Notify3ButtonClicked : SideEffect()
    }
}