package com.tapie.eclair_card.fragment.starting


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
import com.tapie.eclair_card.components.atomic.ButtonProps1
import com.tapie.eclair_card.components.atomic.typography.StartTypography
import com.tapie.eclair_card.navigation.Screen
import com.tapie.eclair_card.data.SharedViewModel


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
        horizontalAlignment = Alignment.CenterHorizontally // Center the content horizontally
    ) {
        Column(
            modifier = Modifier.align(Alignment.CenterHorizontally) // Align inner column to center
        ) {
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
                props = ButtonProps1(
                    text = "완료",
                    buttonHeight = 53,
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

