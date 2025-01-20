package com.example.tradetracker.ui.screens.assets

import com.example.tradetracker.viewmodel.CoinViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tradetracker.ui.components.ApiCoinItem
import com.example.tradetracker.ui.components.NavigationBar
import com.example.tradetracker.ui.components.buttons.BtnPrimary
import com.example.tradetracker.ui.theme.bg
import com.example.tradetracker.ui.theme.yc

enum class SortPreference {
    NONE, ALPHABETICAL, PRICE_DESC
}

@Composable
fun AddScreen(navController: NavController, viewModel: CoinViewModel = viewModel()) {
    val coins = viewModel.coins.collectAsState()
    var sortPreference by remember { mutableStateOf(SortPreference.NONE) }

    val displayedCoins = remember(coins.value, sortPreference) {
        val sortedCoins = when (sortPreference) {
            SortPreference.ALPHABETICAL -> coins.value.sortedBy { it.name }
            SortPreference.PRICE_DESC -> coins.value.sortedByDescending { it.current_price }
            else -> coins.value
        }
        sortedCoins.take(20)
    }

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
                    .height(70.dp),
            ) {
                Text(
                    text = "Add a coin",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Sort A-Z",
                    color = bg,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(yc)
                        .padding(12.dp)
                        .clickable { sortPreference = SortPreference.ALPHABETICAL }
                )

                Spacer(modifier = Modifier.width(50.dp))

                Text(
                    text = "Sort by Price",
                    color = bg,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(yc)
                        .padding(12.dp)
                        .clickable { sortPreference = SortPreference.PRICE_DESC }
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
                    ApiCoinItem(
                        coin,
                        modifier = Modifier
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
