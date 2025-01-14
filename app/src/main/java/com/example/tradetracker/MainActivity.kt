package com.example.tradetracker

import CoinRepository
import CoinViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.tradetracker.models.AuthViewModel
import com.example.tradetracker.models.CoinViewModelFactory
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
