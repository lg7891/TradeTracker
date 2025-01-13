package com.example.tradetracker.ui.components.buttons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tradetracker.ui.theme.bg
import com.example.tradetracker.ui.theme.yc

@Composable
fun BtnPrimary(
    text: String,
    destination: String,
    navController: NavController,
    onClick: () -> Unit,
    extraText: @Composable (() -> Unit)? = null
) {
    Button(
        onClick = {
            navController.navigate(destination)
            onClick()
        },
        modifier = Modifier
            .width(300.dp)
            .height(45.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = yc
        )
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = bg
        )
    }

    extraText?.let {
        it()
    }
}
