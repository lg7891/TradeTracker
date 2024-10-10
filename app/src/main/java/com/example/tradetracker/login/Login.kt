package com.example.tradetracker.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tradetracker.components.BtnPrimary
import com.example.tradetracker.components.InputField
import com.example.tradetracker.ui.theme.bg
import com.example.tradetracker.ui.theme.yc

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bg),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Welcome to \nTrade Tracker",
                fontSize = 48.sp,
                fontWeight = FontWeight(400),
                color = yc,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            InputField(labelText = "USERNAME")
            Spacer(modifier = Modifier.height(8.dp))
            InputField(labelText = "PASSWORD")
            Spacer(modifier = Modifier.height(16.dp))
            BtnPrimary(text = "LOGIN") { }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
            BtnPrimary(text = "SIGNUP") { }
        }
    }
}
