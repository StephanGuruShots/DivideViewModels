package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

abstract class AppViewModel(container2: Container<State, SideEffect>) : ViewModel(),
    ContainerHost<AppViewModel.State, AppViewModel.SideEffect> {

    final override val container = container2

    val state = container.stateFlow.value

    fun doIntent(work: suspend () -> Unit) {
        intent {
            work()
        }
    }

    fun doReduce(newState: State) {
        intent {
            reduce {
                newState
            }
        }
    }

    fun doPostSideEffect(sideEffect: SideEffect) {
        intent {
            postSideEffect(sideEffect)
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