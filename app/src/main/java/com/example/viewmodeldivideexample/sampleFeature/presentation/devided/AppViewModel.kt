package com.example.viewmodeldivideexample.sampleFeature.presentation.devided

abstract class AppViewModel{

    private var parent: AppViewModelImpl? = null

    fun doIntent(work: suspend () -> Unit) {
        parent?.doIntent(work)
    }
    fun doReduce(invoke: (state: AppViewModelImpl.State) -> AppViewModelImpl.State) {
        parent?.doReduce(invoke)
    }
    fun doPostSideEffect(sideEffect: AppViewModelImpl.SideEffect) {
        parent?.doPostSideEffect(sideEffect)
    }

    open fun init(parent: AppViewModelImpl) {
        this.parent = parent
    }
}