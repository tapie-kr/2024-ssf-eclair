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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tapie.eclair_card.components.atomic.CenteredTextButton
import com.tapie.eclair_card.components.atomic.CustomTextInput
import com.tapie.eclair_card.components.atomic.ButtonProps
import com.tapie.eclair_card.components.atomic.typography.StartTypography
import com.tapie.eclair_card.navigation.Screen
import com.tapie.eclair_card.data.SharedViewModel
import kotlinx.coroutines.delay

@Composable
fun StartingScreen(navController: NavController, sharedViewModel: SharedViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(1000)),
            exit = fadeOut(animationSpec = tween(500))
        ) {
            Column {
                Text(
                    text = "당신의 이름을 알려주세요.",
                    style = StartTypography.Name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 18.dp)
                )

                CustomTextInput(
                    hint = "이름",
                    value = name,
                    onValueChange = { name = it },
                    hintStyle = StartTypography.Input,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 18.dp)
                )

                CustomTextInput(
                    hint = "생년월일 (숫자만 써주세요)",
                    value = birthDate,
                    onValueChange = { birthDate = it },
                    hintStyle = StartTypography.Input,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 18.dp)
                )

                CenteredTextButton(
                    props = ButtonProps(
                        text = "완료",
                        icon = null,
                        buttonHeight = 53,
                        buttonWidth = 345
                    ),
                    onClick = {
                        if (name.isNotEmpty() && birthDate.isNotEmpty()) {
                            visible = false
                            sharedViewModel.setUserName(name)
                            sharedViewModel.setBirthDate(birthDate)
                            navController.navigate(Screen.Loading.route)
                        }
                    }
                )
            }
        }
    }
}