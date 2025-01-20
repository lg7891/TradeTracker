@file:Suppress("NAME_SHADOWING")

package com.example.tradetracker.ui.navigation

import com.example.tradetracker.viewmodel.CoinViewModel
import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tradetracker.ui.screens.SettingsScreen
import com.example.tradetracker.ui.screens.signin.LoginScreen
import com.example.tradetracker.ui.screens.signin.SignupScreen
import com.example.tradetracker.ui.screens.assets.AddScreen
import com.example.tradetracker.ui.screens.assets.AssetsScreen
import com.example.tradetracker.ui.screens.assets.CoinDetailScreen
import com.example.tradetracker.viewmodel.AuthViewModel as AuthViewModel1

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
            AssetsScreen(navController)
        }
        composable("add") {
            AddScreen(navController = navController, coinViewModel)
        }
        composable("settings") {
            SettingsScreen(navController, authViewModel)
        }
        composable(
            route = "coin_detail/{coinId}",
            arguments = listOf(navArgument("coinId") { type = NavType.StringType })
        ) { backStackEntry ->
            val coinId = backStackEntry.arguments?.getString("coinId")
            CoinDetailScreen(navController, coinId = coinId, coinViewModel)
        }
    })
}