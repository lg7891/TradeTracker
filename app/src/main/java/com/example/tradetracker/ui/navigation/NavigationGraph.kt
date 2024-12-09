package com.example.tradetracker.ui.navigation

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tradetracker.ui.screens.HelpScreen
import com.example.tradetracker.ui.screens.SettingsScreen
import com.example.tradetracker.ui.screens.signin.LoginScreen
import com.example.tradetracker.ui.screens.signin.SignupScreen
import com.example.tradetracker.ui.screens.assets.AddScreen
import com.example.tradetracker.ui.screens.assets.AssetsScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("signup") {
            SignupScreen(navController = navController)
        }
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("assets") {
            AssetsScreen(navController = navController)
        }
        composable("add") {
            AddScreen(navController = navController)
        }
        composable("settings") {
            SettingsScreen(navController = navController)
        }
        composable("help") {
            HelpScreen(navController = navController)
        }
    }
}