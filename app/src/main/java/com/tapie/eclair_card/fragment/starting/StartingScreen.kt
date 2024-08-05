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
import com.tapie.eclair_card.ui.theme.BlackColor

@Composable
fun StartingScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    // 기준 화면 크기
    val baseWidth = 393.dp
    val baseHeight = 852.dp

    // 현재 화면 크기에 대한 비율 계산
    val widthRatio = screenWidth / baseWidth
    val heightRatio = screenHeight / baseHeight

    // 비율에 맞게 크기 조정
    val textWidth = 345.dp * widthRatio
    val textHeight = 29.dp * heightRatio
    val inputWidth = 345.dp * widthRatio
    val inputHeight = 50.dp * heightRatio
    val buttonWidth = 345.dp * widthRatio
    val buttonHeight = 53.dp * heightRatio
    val spacing = 24.dp * heightRatio

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = (screenWidth - textWidth) / 2), // 수평 여백 조정
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "당신의 이름을 알려주세요.",
            style = StartTypography.Name,
            modifier = Modifier
                .width(textWidth)
                .height(textHeight)
                .padding(bottom = spacing)
        )

        CustomTextInput(
            value = name,
            onValueChange = { name = it },
            hint = "이름",
            hintStyle = StartTypography.Input, // hint 스타일 지정
            textColor = BlackColor,
            modifier = Modifier
                .width(inputWidth)
                .height(inputHeight)
                .padding(vertical = spacing)
        )

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