package com.example.tradetracker.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.tradetracker.ui.theme.yc


@Composable
fun NavigationBar(navController: NavController) {
    data class BottomNavigationItem(
        val title: String,
        val selectedIcon: ImageVector,
        val unselectedIcon: ImageVector,
        val route: String
    )

    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = "home"
        ),
        BottomNavigationItem(
            title = "Help",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
            route = "help"
        ),
        BottomNavigationItem(
            title = "Add",
            selectedIcon = Icons.Filled.Add,
            unselectedIcon = Icons.Outlined.Add,
            route = "add"
        ),
        BottomNavigationItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            route = "settings"
        )
    )
    var selectedItem by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        androidx.compose.material3.NavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            containerColor = Black,
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = if (selectedItem == index) item.selectedIcon else item.unselectedIcon,
                            contentDescription = item.title,
                            tint = if (selectedItem == index) Black else White
                        )
                    },
                    label = {
                        Text(text = item.title, color = White)
                    },
                    selected = selectedItem == index,
                    onClick = {
                        selectedItem = index
                        navController.navigate(item.route)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = yc
                    )
                )
            }
        }
    }

}