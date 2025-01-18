package com.example.tradetracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tradetracker.models.ApiCoin
import com.example.tradetracker.ui.theme.bg

@Composable
fun ApiCoinItem(apiCoin: ApiCoin, modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(bg),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = apiCoin.name,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 25.sp,
            modifier = Modifier.weight(1f),
        )

        Text(
            text = "Amount: ${apiCoin.current_price}",
            fontSize = 25.sp,
            color = Color.White
        )
    }
}