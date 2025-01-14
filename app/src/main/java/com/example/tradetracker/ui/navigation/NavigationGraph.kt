@file:Suppress("NAME_SHADOWING")

package com.example.tradetracker.ui.navigation

import CoinViewModel
import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tradetracker.models.AuthViewModel
import com.example.tradetracker.ui.screens.HelpScreen
import com.example.tradetracker.ui.screens.SettingsScreen
import com.example.tradetracker.ui.screens.signin.LoginScreen
import com.example.tradetracker.ui.screens.signin.SignupScreen
import com.example.tradetracker.ui.screens.assets.AddScreen
import com.example.tradetracker.ui.screens.assets.AssetsScreen
import com.example.tradetracker.models.AuthViewModel as AuthViewModel1

@Composable
fun NavigationGraph(authViewModel: AuthViewModel1, coinViewModel: CoinViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login") {
            LoginScreen(navController, authViewModel)
        }
        composable("signup") {
            SignupScreen(navController, authViewModel)
        }
        composable("home") {
            HomeScreen(navController, authViewModel)
        }
        composable("assets") {
            AssetsScreen(navController, coinViewModel)
        }
        composable("add") {
            AddScreen(navController = navController)
        }
        composable("settings") {
            SettingsScreen(navController, authViewModel)
        }
        composable("help") {
            HelpScreen(navController)
        }
    })
}