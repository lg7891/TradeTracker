package com.example.tradetracker.components

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
import com.example.tradetracker.ui.theme.bg
import com.example.tradetracker.ui.theme.yc

@Composable
fun BtnPrimary(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
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
}
