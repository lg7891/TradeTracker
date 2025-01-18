package com.example.tradetracker

import com.example.tradetracker.api.CoinRepository
import com.example.tradetracker.viewmodel.CoinViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.tradetracker.viewmodel.AuthViewModel
import com.example.tradetracker.viewmodel.CoinViewModelFactory
import com.example.tradetracker.ui.navigation.NavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel : AuthViewModel by viewModels()
        val repository = CoinRepository(ApiClient.coinGeckoApi)
        val viewModelFactory = CoinViewModelFactory(repository)
        val coinViewModel = ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
        setContent {
            NavigationGraph(authViewModel = authViewModel, coinViewModel = coinViewModel)
        }
    }
}
