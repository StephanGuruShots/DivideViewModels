package com.example.viewmodeldivideexample.sampleFeature.presentation

//@HiltViewModel
//class SampleViewModel @Inject constructor() : AppViewModelImpl(DeleteObj.container) {
//
//    fun sendAction(action: Action) {
//        when (action) {
//            Action.Button1Clicked -> {
//                doIntent {
//                    doReduce(
//                        state.copy(
//                            buttonText = state.text1
//                        )
//                    )
//                    doPostSideEffect(SideEffect.Notify1ButtonClicked)
//                }
//            }
//
//            Action.Button2Clicked -> {
//                doIntent {
//                    doReduce(
//                        state.copy(
//                            buttonText = state.text2
//                        )
//                    )
//                    doPostSideEffect(SideEffect.Notify2ButtonClicked)
//                }
//            }
//
//            Action.Button3Clicked -> {
//                doIntent {
//                    doReduce(
//                        state.copy(
//                            buttonText = state.text3
//                        )
//                    )
//                    doPostSideEffect(SideEffect.Notify3ButtonClicked)
//                }
//            }
//        }
//    }
//}