package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import android.util.Log
import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class AppViewModelImpl() : ViewModel(),
    ContainerHost<AppViewModelImpl.State, AppViewModelImpl.SideEffect>, AppViewModel {

    override val container: Container<State, SideEffect> = container(State())

    override fun doIntent(work: suspend () -> Unit) {
        intent {
            work()
        }
    }

    override fun doReduce(invoke: (state: State) -> State) {
        intent {
            reduce {
                invoke(state)
            }
        }
    }

    override fun doPostSideEffect(sideEffect: SideEffect) {
        intent {
            postSideEffect(sideEffect)
        }
    }

    data class State(
        val text1: String = "text1",
        val text2: String = "text2",
        val text3: String = "text3",
        val buttonText: String = "empty",
        val intValue: String = "int value"
    )

    sealed class Action {
        data object Button1Clicked : Action()
        data object Button2Clicked : Action()
        data object Button3Clicked : Action()
        data object IntButtonClicked : Action()
    }

    sealed class SideEffect {
        data object Notify1ButtonClicked : SideEffect()
        data object Notify2ButtonClicked : SideEffect()
        data object Notify3ButtonClicked : SideEffect()
    }
}