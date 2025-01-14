package com.example.tradetracker.ui.screens.assets

import CoinViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tradetracker.ui.components.NavigationBar

@Composable
fun AddScreen(navController: NavController, viewModel: CoinViewModel = viewModel()) {
    Box() {
        Text(
            text = "Add Screen"
        )
        Column {
            NavigationBar(navController)
        }
    }
}