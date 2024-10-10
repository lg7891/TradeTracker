package com.example.tradetracker.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tradetracker.ui.theme.yc
import com.example.tradetracker.ui.theme.bg

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bg),
        contentAlignment = Alignment.Center
    ) {
        Row(
            ) {
            Text(
                text = "Tra",
                color = yc,
                fontSize = 84.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier.weight(1f)
            )

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "de",
                    color = yc,
                    fontSize = 54.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "cker",
                    color = yc,
                    fontSize = 54.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}