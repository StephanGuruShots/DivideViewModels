package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import org.orbitmvi.orbit.ContainerHost

interface AppViewModel{
    fun doIntent(work: suspend () -> Unit)
    fun doReduce(invoke: (state: AppViewModelImpl.State) -> AppViewModelImpl.State)
    fun doPostSideEffect(sideEffect: AppViewModelImpl.SideEffect)

    fun init(parent: AppViewModel)
}