package com.example.tradetracker.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tradetracker.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun CoinElement() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(2.dp, color = Color.White)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.currency_bitcoin),
                contentDescription = "Bitcoin",
                tint = Color.White,
            )
            Text(
                text = "100'000$",
                color = Color.White,
                fontSize = 40.sp,
            )
        }
    }
}