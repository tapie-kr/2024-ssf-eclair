package com.tapie.eclair_card.components.nav

import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tapie.eclair_card.R
import com.tapie.eclair_card.components.atomic.*

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: @Composable (Modifier) -> Unit,
    val selectedIcon: @Composable (Modifier) -> Unit
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Taro", "taro", { TaroIcon(it) }, { TaroChosenIcon(it) }),
        BottomNavItem("Home", "home", { HomeIcon(it) }, { HomeChosenIcon(it) }),
        BottomNavItem("Luck", "luck", { LuckIcon(it) }, { LuckChosenIcon(it) })
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    if (currentRoute == item.route) {
                        item.selectedIcon(Modifier)
                    } else {
                        item.icon(Modifier)
                    }
                },
                label = { Text(item.name) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}