package com.example.tradetracker.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.tradetracker.ui.components.NavigationBar

@Composable
fun SettingsScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Settings screen"
            )
            NavigationBar(navController)
        }
    }
}