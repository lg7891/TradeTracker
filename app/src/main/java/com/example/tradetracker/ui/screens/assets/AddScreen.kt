package com.example.tradetracker.ui.screens.assets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.tradetracker.ui.components.NavigationBar

@Composable
fun AddScreen(navController: NavController) {
    Box() {
        Text(
            text = "Add Screen"
        )
        Column {
            NavigationBar(navController)
        }
    }
}