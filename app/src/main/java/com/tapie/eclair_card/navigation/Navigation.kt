package com.tapie.eclair_card.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tapie.eclair_card.components.nav.BottomNavigationBar
import com.tapie.eclair_card.fragment.home.HomeScreen
import com.tapie.eclair_card.fragment.luck.LuckScreen
import com.tapie.eclair_card.fragment.starting.LogoScreen
import com.tapie.eclair_card.fragment.starting.StartingScreen
import com.tapie.eclair_card.fragment.taro.TaroScreen

sealed class Screen(val route: String) {
    object Logo : Screen("logo")
    object Starting : Screen("starting")
    object Home : Screen("home")
    object Luck : Screen("luck")
    object Taro : Screen("taro")
}

@Composable
fun Navigation(userName: MutableState<String>) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Logo.route && currentRoute != Screen.Starting.route) {
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = Screen.Logo.route, modifier = Modifier.padding(innerPadding)) {
            composable(Screen.Logo.route) { LogoScreen(navController) }
            composable(Screen.Starting.route) { StartingScreen(navController, userName) }
            composable(Screen.Home.route) { HomeScreen(navController, userName.value) }
            composable(Screen.Luck.route) { LuckScreen(navController) }
            composable(Screen.Taro.route) { TaroScreen(navController) }
        }
    }
}