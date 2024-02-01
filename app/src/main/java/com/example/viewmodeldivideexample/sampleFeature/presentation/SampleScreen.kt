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
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun SampleScreen() {

    val viewModel: SampleViewModel = hiltViewModel()
    val screenState = viewModel.collectAsState()

    val context = LocalContext.current

    viewModel.collectSideEffect { sideEffect ->
        when(sideEffect) {
            SampleViewModel.SideEffect.Notify1ButtonClicked -> {
                Toast.makeText(context, "btn 1 clicked", Toast.LENGTH_SHORT).show()
            }
            SampleViewModel.SideEffect.Notify2ButtonClicked -> {
                Toast.makeText(context, "btn 2 clicked", Toast.LENGTH_SHORT).show()
            }
            SampleViewModel.SideEffect.Notify3ButtonClicked -> {
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
                    viewModel.sendAction(SampleViewModel.Action.Button1Clicked)
                }) {
                    Text(text = screenState.value.buttonText)
                }
                Text(text = screenState.value.text1)
            }
            Row {
                Button(onClick = {
                    viewModel.sendAction(SampleViewModel.Action.Button2Clicked)
                }) {
                    Text(text = screenState.value.buttonText)
                }
                Text(text = screenState.value.text2)
            }
            Row {
                Button(onClick = {
                    viewModel.sendAction(SampleViewModel.Action.Button3Clicked)
                }) {
                    Text(text = screenState.value.buttonText)
                }
                Text(text = screenState.value.text3)
            }
        }
    }
}