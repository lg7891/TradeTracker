package com.example.tradetracker.ui.screens.assets

import CoinGeckoApi
import CoinViewModel
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tradetracker.ui.components.InputField
import com.example.tradetracker.ui.components.buttons.BtnSecondary
import com.example.tradetracker.ui.theme.bg
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun CoinDetailScreen(navController: NavController, coinId: String?, viewModel: CoinViewModel = viewModel()) {
    var coinName by remember { mutableStateOf("Loading...") }
    var coinValue by remember { mutableStateOf("Loading...") }
    var coinAmount by remember { mutableStateOf("") }
    var isValidAmount by remember { mutableStateOf(true) }

    val numberRegex = Regex("^[0-9]+(\\\\,[0-9]{1,2})?\$")

    LaunchedEffect(coinId) {
        if (coinId != null) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://api.coingecko.com/api/v3/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                    val api = retrofit.create(CoinGeckoApi::class.java)
                    val coins = api.getCoins(vsCurrency = "usd")

                    val coin = coins.find { it.id == coinId }
                    if (coin != null) {
                        coinName = coin.name
                        coinValue = "$${coin.current_price}"
                    } else {
                        coinName = "Coin not found"
                        coinValue = "N/A"
                    }
                } catch (e: Exception) {
                    coinName = "Error fetching data"
                    coinValue = "N/A"
                }
            }
        } else {
            coinName = "Invalid Coin ID"
            coinValue = "N/A"
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                Text(
                    text = "Coin Detail",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 50.sp,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 10.dp)
                        .fillMaxWidth()
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(bg)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Coin name: $coinName",
                        color = Color.White,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Current value: $coinValue",
                        color = Color.White,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    InputField(
                        labelText = "Enter amount",
                        value = coinAmount,
                        onValueChange = {
                            coinAmount = it
                            isValidAmount = numberRegex.matches(it)
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    BtnSecondary(
                        onClick = {
                            if (isValidAmount) {
                                navController.navigate("assets")
                            } else {
                                navController.navigate("home")
                            }
                        },
                        text = "ADD",
                        destination = "assets",
                        navController = navController
                    ) {}
                }
            }
        }
    }
}
