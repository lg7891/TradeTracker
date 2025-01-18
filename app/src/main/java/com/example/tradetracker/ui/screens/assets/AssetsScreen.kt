package com.example.tradetracker.ui.screens.assets

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tradetracker.data.PortfolioDatabase
import com.example.tradetracker.models.UserCoin
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.tradetracker.ui.components.NavigationBar
import com.example.tradetracker.ui.theme.bg

@Composable
fun AssetsScreen(navController: NavController) {
    val context = LocalContext.current
    var userCoins by remember { mutableStateOf(emptyList<UserCoin>()) }

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
                    text = "Your Assets",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 50.sp,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 10.dp)
                        .fillMaxWidth()
                )
            }
            LaunchedEffect(Unit) {
                val dao = PortfolioDatabase.getDatabase(context).userCoinDao()
                dao.getAllUserCoins().collect { coins ->
                    userCoins = coins
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(bg),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(userCoins) { coin ->
                    UserCoinItem(
                        userCoin = coin,
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, Color.Gray)
                            .padding(8.dp)
                            .clickable { navController.navigate("coin_detail/${coin.id}") }
                        )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
    NavigationBar(navController)
}