package com.drone.activation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.drone.activation.model.UiState

@Composable
fun ActivationScreen(
    uiState: UiState,
    onIpChanged: (String) -> Unit = {},
    onConnect: () -> Unit = {},
    onVerify: () -> Unit = {},
    onActivate: () -> Unit = {},
    onLogout: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "无人机实名激活",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = uiState.ip,
            onValueChange = onIpChanged,
            label = {
                Text("无人机IP")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onConnect
        ) {

            Text("连接无人机")

        }

        Spacer(modifier = Modifier.height(20.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(20.dp))

        Text("SN：${uiState.serialNumber}")

        Spacer(modifier = Modifier.height(8.dp))

        Text("实名状态：${uiState.verifyStatus}")

        Spacer(modifier = Modifier.height(8.dp))

        Text("激活状态：${uiState.activationStatus}")

        Spacer(modifier = Modifier.height(20.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onVerify
        ) {

            Text("实名验证")

        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onActivate
        ) {

            Text("激活")

        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onLogout
        ) {

            Text("注销")

        }

    }

}