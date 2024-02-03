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
import com.example.viewmodeldivideexample.sampleFeature.presentation.devided.AppViewModel
import com.example.viewmodeldivideexample.sampleFeature.presentation.devided.FirstViewModel
import com.example.viewmodeldivideexample.sampleFeature.presentation.devided.SecondViewModel
import com.example.viewmodeldivideexample.sampleFeature.presentation.devided.ThirdViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun SampleScreen() {

//    val viewModel: SampleViewModel = hiltViewModel()
    val firstViewModel: FirstViewModel = hiltViewModel()
    val secondViewModel: SecondViewModel = hiltViewModel()
    val thirdViewModel: ThirdViewModel = hiltViewModel()

    val screenState = firstViewModel.collectAsState()

    val context = LocalContext.current

    firstViewModel.collectSideEffect { sideEffect ->
        when(sideEffect) {
            AppViewModel.SideEffect.Notify1ButtonClicked -> {
                Toast.makeText(context, "btn 1 clicked", Toast.LENGTH_SHORT).show()
            }
            AppViewModel.SideEffect.Notify2ButtonClicked -> {
                Toast.makeText(context, "btn 2 clicked", Toast.LENGTH_SHORT).show()
            }
            AppViewModel.SideEffect.Notify3ButtonClicked -> {
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
                    firstViewModel.sendAction(AppViewModel.Action.Button1Clicked)
                }) {
                    Text(text = screenState.value.buttonText)
                }
                Text(text = screenState.value.text1)
            }
            Row {
                Button(onClick = {
                    secondViewModel.sendAction(AppViewModel.Action.Button2Clicked)
                }) {
                    Text(text = screenState.value.buttonText)
                }
                Text(text = screenState.value.text2)
            }
            Row {
                Button(onClick = {
                    thirdViewModel.sendAction(AppViewModel.Action.Button3Clicked)
                }) {
                    Text(text = screenState.value.buttonText)
                }
                Text(text = screenState.value.text3)
            }
        }
    }
}