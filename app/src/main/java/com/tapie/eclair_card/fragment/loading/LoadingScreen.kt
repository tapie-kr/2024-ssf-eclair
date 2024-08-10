package com.tapie.eclair_card.fragment.loading

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tapie.eclair_card.components.atomic.LoadingIcon
import com.tapie.eclair_card.navigation.Screen
import com.tapie.eclair_card.data.SharedViewModel
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(navController: NavController, sharedViewModel: SharedViewModel = viewModel()) {
    var visible by remember { mutableStateOf(true) }
    var isDataLoaded by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        sharedViewModel.fetchHoroscope {
            isDataLoaded = true
        }
    }

    LaunchedEffect(isDataLoaded) {
        if (isDataLoaded) {
            delay(1000) // Optional delay for better UX
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Starting.route) { inclusive = true }
            }
        }
    }

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val logoSize = screenWidth / 4

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LoadingIcon(modifier = Modifier.size(logoSize))
    }
}