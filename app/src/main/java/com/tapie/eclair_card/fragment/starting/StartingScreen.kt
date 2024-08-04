package com.tapie.eclair_card.fragment.starting

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tapie.eclair_card.components.atomic.CenteredTextButton
import com.tapie.eclair_card.components.atomic.CustomTextInput
import com.tapie.eclair_card.components.atomic.ButtonProps
import com.tapie.eclair_card.components.atomic.typography.StartTypography

@Composable
fun StartingScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val textWidth = screenWidth * 345 / 393
    val textHeight = screenHeight * 29 / 852
    val inputWidth = screenWidth * 345 / 393
    val inputHeight = screenHeight * 50 / 852
    val buttonWidth = screenWidth * 345 / 393
    val buttonHeight = screenHeight * 53 / 852

    val spacing = screenHeight * 24 / 852

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = (screenWidth - textWidth) / 2), // 수평 여백 조정
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "당신의 이름을 알려주세요.",
            style = StartTypography.labelLarge,
            modifier = Modifier
                .width(textWidth)
                .padding(bottom = spacing)
        )

        CustomTextInput(
            hint = "이름",
            onTextChanged = { name = it },
            modifier = Modifier
                .width(inputWidth)
                .height(inputHeight)
                .padding(vertical = spacing)
        )

        //여기 아직 안 됨 text가 안 보임

        CenteredTextButton(
            props = ButtonProps(
                text = "완료",
                icon = null,
                buttonHeight = buttonHeight.value.toInt(),
                buttonWidth = buttonWidth.value.toInt()
            ),
            onClick = {
                navController.navigate("home")
            },
            modifier = Modifier.padding(vertical = spacing)
        )
    }
}