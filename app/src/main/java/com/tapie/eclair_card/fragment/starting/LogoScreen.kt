package com.tapie.eclair_card.fragment.starting

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
import androidx.navigation.NavController
import com.tapie.eclair_card.components.atomic.LogoIcon
import kotlinx.coroutines.delay

@Composable
fun LogoScreen(navController: NavController) {
    var visible by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(1000)
        visible = false
        delay(500)
        navController.navigate("starting") {
            popUpTo("loading") { inclusive = true }
        }
    }

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val logoSize = screenWidth / 4

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LogoIcon(modifier = Modifier.size(logoSize))
    }
}