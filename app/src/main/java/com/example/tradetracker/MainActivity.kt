package com.example.tradetracker

import HomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.tradetracker.models.AuthViewModel
import com.example.tradetracker.ui.navigation.NavigationGraph
import com.example.tradetracker.ui.theme.TradeTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel : AuthViewModel by viewModels()

        setContent {
            NavigationGraph(authViewModel = authViewModel)
        }
    }
}
