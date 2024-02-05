package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

import org.orbitmvi.orbit.ContainerHost

interface AppViewModel : ContainerHost<AppViewModelImpl.State, AppViewModelImpl.SideEffect> {
    fun doIntent(work: suspend () -> Unit)
    fun doReduce(invoke: (state: AppViewModelImpl.State) -> AppViewModelImpl.State)
    fun doPostSideEffect(sideEffect: AppViewModelImpl.SideEffect)
}