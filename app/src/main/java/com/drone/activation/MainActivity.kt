package com.drone.activation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.drone.activation.model.UiState
import com.drone.activation.ui.ActivationScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            var uiState by remember {

                mutableStateOf(UiState())

            }

            ActivationScreen(

                uiState = uiState,

                onIpChanged = {

                    uiState = uiState.copy(ip = it)

                }

            )

        }

    }

}