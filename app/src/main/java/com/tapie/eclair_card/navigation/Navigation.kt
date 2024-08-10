package com.tapie.eclair_card.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tapie.eclair_card.components.nav.BottomNavigationBar
import com.tapie.eclair_card.fragment.home.HomeScreen
import com.tapie.eclair_card.fragment.loading.LoadingScreen
import com.tapie.eclair_card.fragment.luck.LuckScreen
import com.tapie.eclair_card.fragment.starting.LogoScreen
import com.tapie.eclair_card.fragment.starting.StartingScreen
import com.tapie.eclair_card.fragment.taro.TaroScreen
import com.tapie.eclair_card.data.SharedViewModel

sealed class Screen(val route: String) {
    object Logo : Screen("logo")
    object Starting : Screen("starting")
    object Loading : Screen("loading")
    object Home : Screen("home")
    object Luck : Screen("luck")
    object Taro : Screen("taro")
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val sharedViewModel: SharedViewModel = viewModel()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Logo.route && currentRoute != Screen.Starting.route && currentRoute != Screen.Loading.route) {
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        AnimatedContent(
            targetState = currentRoute,
            transitionSpec = {
                fadeIn(animationSpec = tween(1000)) with fadeOut(animationSpec = tween(500))
            }
        ) { targetRoute ->
            NavHost(navController = navController, startDestination = Screen.Logo.route, modifier = Modifier.padding(innerPadding)) {
                composable(Screen.Logo.route) { LogoScreen(navController) }
                composable(Screen.Starting.route) { StartingScreen(navController, sharedViewModel) }
                composable(Screen.Loading.route) { LoadingScreen(navController, sharedViewModel) }
                composable(Screen.Home.route) { HomeScreen(navController, sharedViewModel) }
                composable(Screen.Luck.route) { LuckScreen(navController, sharedViewModel) }
                composable(Screen.Taro.route) { TaroScreen(navController, sharedViewModel) }
            }
        }
    }
}

