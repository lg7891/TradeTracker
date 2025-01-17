package com.example.tradetracker.ui.components.buttons

import androidx.compose.foundation.border
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
fun BtnSecondary(
    text: String,
    navController: NavController,
    onClick: () -> Unit,
    extraText: @Composable (() -> Unit)? = null
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(300.dp)
            .height(45.dp)
            .border(width = 1.dp, color = yc),
        colors = ButtonDefaults.buttonColors(
            containerColor = bg
        )
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = yc
        )
    }
}
