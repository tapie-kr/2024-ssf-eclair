package com.tapie.eclair_card.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Logo.route) {
        composable(Screen.Logo.route) { LogoScreen(navController) }
        composable(Screen.Starting.route) { StartingScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Luck.route) { LuckScreen(navController) }
        composable(Screen.Taro.route) { TaroScreen(navController) }
    }
}