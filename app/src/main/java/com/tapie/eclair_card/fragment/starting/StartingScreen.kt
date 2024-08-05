package com.tapie.eclair_card.fragment.starting

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tapie.eclair_card.components.atomic.CenteredTextButton
import com.tapie.eclair_card.components.atomic.CustomTextInput
import com.tapie.eclair_card.components.atomic.ButtonProps
import com.tapie.eclair_card.components.atomic.typography.StartTypography
import com.tapie.eclair_card.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun StartingScreen(navController: NavController, userName: MutableState<String>) {
    var name by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(true) }
    var navigateToHome by remember { mutableStateOf(false) }

    LaunchedEffect(navigateToHome) {
        if (navigateToHome) {
            delay(500)
            userName.value = name
            navController.navigate(Screen.Home.route)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(1000)),
            exit = fadeOut(animationSpec = tween(500))
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "당신의 이름을 알려주세요.",
                    style = StartTypography.Name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 18.dp)
                )

                CustomTextInput(
                    value = name,
                    onValueChange = { name = it },
                    hint = "이름",
                    hintStyle = StartTypography.Input,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 18.dp)
                )

                CenteredTextButton(
                    props = ButtonProps(
                        text = "완료",
                        icon = null,
                        buttonHeight = 53, // 버튼의 높이 조정
                        buttonWidth = 345 // 버튼의 너비 조정
                    ),
                    onClick = {
                        if (name.isNotEmpty()) {
                            visible = false
                            navigateToHome = true
                        }
                    }
                )
            }
        }
    }
}