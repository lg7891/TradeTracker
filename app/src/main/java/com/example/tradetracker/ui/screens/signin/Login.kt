package com.example.tradetracker.ui.screens.signin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tradetracker.viewmodel.AuthState
import com.example.tradetracker.viewmodel.AuthViewModel
import com.example.tradetracker.ui.components.buttons.BtnPrimary
import com.example.tradetracker.ui.components.InputField
import com.example.tradetracker.ui.theme.bg
import com.example.tradetracker.ui.theme.yc

@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel) {

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("home")
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

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
                modifier = Modifier.padding(bottom = 32.dp),
                lineHeight = 56.sp
            )

            InputField(
                labelText = "USERNAME",
                value = email,
                onValueChange = {
                    email = it
                })

            Spacer(modifier = Modifier.height(8.dp))

            InputField(
                labelText = "PASSWORD",
                value = password,
                onValueChange = {
                    password = it
                })

            Spacer(modifier = Modifier.height(16.dp))

            BtnPrimary(
                onClick = {
                    authViewModel.login(email, password)
                },
                text = "LOGIN",
                destination = "home",
                navController = navController,
                ) {}

            Spacer(modifier = Modifier.height(8.dp))

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            TextButton(onClick = {
                navController.navigate("signup")
            }) {
                Text(text = "Don't have an account, Signup", color = Color.White)
            }
        }
    }
}
