package com.example.viewmodeldivideexample.sampleFeature.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.viewmodeldivideexample.sampleFeature.presentation.devided.AppViewModelImpl
import com.example.viewmodeldivideexample.sampleFeature.presentation.devided.FirstViewModelImpl
import com.example.viewmodeldivideexample.sampleFeature.presentation.devided.SecondViewModelImpl
import com.example.viewmodeldivideexample.sampleFeature.presentation.devided.ThirdViewModelImpl
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun SampleScreen() {

    val appViewModel: AppViewModelImpl = hiltViewModel()

    val screenState = appViewModel.collectAsState()

    val context = LocalContext.current

    appViewModel.collectSideEffect { sideEffect ->
        when(sideEffect) {
            AppViewModelImpl.SideEffect.Notify1ButtonClicked -> {
                Toast.makeText(context, "btn 1 clicked", Toast.LENGTH_SHORT).show()
            }
            AppViewModelImpl.SideEffect.Notify2ButtonClicked -> {
                Toast.makeText(context, "btn 2 clicked", Toast.LENGTH_SHORT).show()
            }
            AppViewModelImpl.SideEffect.Notify3ButtonClicked -> {
                Toast.makeText(context, "btn 3 clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Scaffold {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Row {
                Button(onClick = {
                    appViewModel.firstViewModel.sendAction(AppViewModelImpl.Action.Button1Clicked)
                }) {
                    Text(text = screenState.value.buttonText)
                }
                Text(text = screenState.value.text1)
            }
            Row {
                Button(onClick = {
                    appViewModel.secondViewModel.sendAction(AppViewModelImpl.Action.Button2Clicked)
                }) {
                    Text(text = screenState.value.buttonText)
                }
                Text(text = screenState.value.text2)
            }
            Row {
                Button(onClick = {
                    appViewModel.thirdViewModel.sendAction(AppViewModelImpl.Action.Button3Clicked)
                }) {
                    Text(text = screenState.value.buttonText)
                }
                Text(text = screenState.value.text3)
            }
            Row {
                Button(onClick = {
                    appViewModel.thirdViewModel.sendAction(AppViewModelImpl.Action.IntButtonClicked)
                }) {
                    Text(text = "click to get int")
                }
                Text(text = screenState.value.intValue)
            }
        }
    }
}