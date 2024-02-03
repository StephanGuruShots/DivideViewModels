package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class Delete : ViewModel(),
    ContainerHost<AppViewModel.State, AppViewModel.SideEffect> {

    override val container: Container<AppViewModel.State, AppViewModel.SideEffect> = container(
        AppViewModel.State()
    )
}

object DeleteObj {
    val container = Delete().container
}