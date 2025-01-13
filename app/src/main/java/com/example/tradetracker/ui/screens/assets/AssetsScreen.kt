package com.example.tradetracker.ui.screens.assets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tradetracker.ui.components.NavigationBar
import com.example.tradetracker.ui.components.CoinElement
import com.example.tradetracker.ui.theme.bg

@Composable
fun AssetsScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bg),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .background(Color.Black)
                    .height(70.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Assets",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 50.sp,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 10.dp)
                )
            }
            for (i in 1..10) {
                CoinElement()
            }
            NavigationBar(navController)
        }
    }
}