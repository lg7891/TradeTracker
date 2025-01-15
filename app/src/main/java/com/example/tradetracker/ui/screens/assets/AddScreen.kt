package com.example.tradetracker.ui.screens.assets

import Coin
import CoinViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tradetracker.ui.components.NavigationBar
import com.example.tradetracker.ui.theme.bg

@Composable
fun AddScreen(navController: NavController, viewModel: CoinViewModel = viewModel()) {
    val coins = viewModel.coins.collectAsState()
    val displayedCoins = coins.value.take(20)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bg),
    ) {
        Column(
            modifier = Modifier
                .background(bg)
        ) {
            Row(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                Text(
                    text = "Add a coin",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 50.sp,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 10.dp)
                        .fillMaxWidth()
                )
            }

            LaunchedEffect(Unit) {
                viewModel.fetchCoins("usd")
            }

            LazyColumn(
                modifier = Modifier
                    .background(bg),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(displayedCoins.size) { index ->
                    val coin = displayedCoins[index]
                    CoinItem(
                        coin, modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, Color.Gray)
                            .padding(8.dp)
                            .clickable { navController.navigate("coin_detail/${coin.id}") }
                    )
                }
            }
            NavigationBar(navController)
        }
    }
}

@Composable
fun CoinItem(coin: Coin, modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(bg),
        verticalAlignment = Alignment.CenterVertically
    ) {
//        Image(
//            painter = rememberAsyncImagePainter(data = coin.image),
//            contentDescription = coin.name,
//            modifier = Modifier.size(40.dp)
//        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = coin.name,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 25.sp,
            modifier = Modifier.weight(1f),
        )

        Text(
            text = "Price: $${coin.current_price}",
            fontSize = 25.sp,
            color = Color.White
        )
    }
}