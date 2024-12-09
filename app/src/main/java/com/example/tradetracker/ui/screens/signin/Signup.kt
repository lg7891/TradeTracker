package com.example.tradetracker.ui.screens.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tradetracker.ui.components.buttons.BtnPrimary
import com.example.tradetracker.ui.components.InputField
import com.example.tradetracker.ui.theme.bg
import com.example.tradetracker.ui.theme.yc

@Composable
fun SignupScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bg),
        contentAlignment = Alignment.Center
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            Text(
                text = "Welcome to \nTrade Tracker",
                fontSize = 48.sp,
                fontWeight = FontWeight(400),
                color = yc,
                modifier = Modifier.padding(bottom = 16.dp),
                lineHeight = 56.sp
            )
            InputField(labelText = "USERNAME")
            Spacer(modifier = Modifier.height(8.dp))
            InputField(labelText = "PASSWORD")
            Spacer(modifier = Modifier.height(16.dp))
            BtnPrimary(text = "CREATE ACCOUNT", destination = "home", navController = navController)
        }
    }
}