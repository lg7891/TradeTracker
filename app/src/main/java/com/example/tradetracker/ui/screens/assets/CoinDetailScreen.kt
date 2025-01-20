package com.example.tradetracker.ui.screens.assets

import AlertDialog
import com.example.tradetracker.viewmodel.CoinViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.example.tradetracker.data.PortfolioDatabase
import com.example.tradetracker.models.UserCoin
import com.example.tradetracker.ui.components.InputField
import com.example.tradetracker.ui.components.buttons.BtnSecondary
import com.example.tradetracker.ui.theme.bg
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CoinDetailScreen(navController: NavController, coinId: String?, viewModel: CoinViewModel = viewModel()) {
    val coinDetails by viewModel.apiCoinDetails.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    var coinAmount by remember { mutableStateOf("") }
    var validEntry by remember { mutableStateOf(false) }
    val entryReg = Regex("^[0-9]+\\.?[0-9]*\$")
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false }
        )
    }

    LaunchedEffect(coinId) {
        coinId?.let { viewModel.fetchCoinDetails(it) }
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
                    when {
                        errorMessage != null -> {
                            Text(
                                text = errorMessage!!,
                                color = Color.Red,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp)
                            )
                        }

                        coinDetails != null -> {
                            Text(
                                text = "Coin name: ${coinDetails!!.name}",
                                color = Color.White,
                                fontSize = 30.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 16.dp)
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = "Current value: $${coinDetails!!.current_price}",
                                color = Color.White,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }

                        else -> {
                            Text(
                                text = "Loading...",
                                color = Color.Gray,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    InputField(
                        labelText = "Enter Amount",
                        value = coinAmount,
                        onValueChange = {
                            coinAmount = it
                            validEntry = coinAmount.matches(entryReg)

                            println("Current Input: $coinAmount")
                            println("Valid Entry: $validEntry")
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    BtnSecondary(
                        onClick = {
                            if (validEntry) {
                                val userCoin = coinDetails?.let {
                                    UserCoin(
                                        id = System.currentTimeMillis().toString(),
                                        name = it.name,
                                        amount = coinAmount.toDoubleOrNull() ?: 0.0
                                    )
                                }

                                CoroutineScope(Dispatchers.IO).launch {
                                    val dao = PortfolioDatabase.getDatabase(context).userCoinDao()
                                    if (userCoin != null) {
                                        dao.insertUserCoin(userCoin)
                                    }
                                }
                                navController.navigate("assets")
                            } else {
                                showDialog = true
                            }
                        },
                        text = "ADD",
                        navController = navController
                    )
                }
            }
        }
    }
}