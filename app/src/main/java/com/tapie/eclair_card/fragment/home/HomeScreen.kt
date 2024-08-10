package com.tapie.eclair_card.fragment.home

import LuckCardList
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tapie.eclair_card.components.atomic.LogoIcon
import com.tapie.eclair_card.components.atomic.typography.HomeTypography
import com.tapie.eclair_card.components.atomic.typography.StartTypography
import com.tapie.eclair_card.data.SharedViewModel
import com.tapie.eclair_card.ui.theme.LightPurpleColor

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.tapie.eclair_card.components.atomic.ButtonProps
import com.tapie.eclair_card.components.atomic.LeftTextRightIconButton
import com.tapie.eclair_card.ui.theme.BlackColor

@Composable
fun HomeScreen(navController: NavController, sharedViewModel: SharedViewModel = viewModel()) {
    val userName by sharedViewModel.userName.observeAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp),  // 왼쪽과 오른쪽 14dp 패딩 적용
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
            // LogoIcon (왼쪽 위)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),  // 위와 아래로 24dp 패딩 적용
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LogoIcon(
                modifier = Modifier.size(40.dp)
            )

            Text(
                text = "홈",
                style = HomeTypography.Home,
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = LightPurpleColor)) {
                    append(userName.trim())
                }
                withStyle(style = SpanStyle(color = BlackColor)) {
                    append("님")  // 공백 없이 바로 "님"을 추가
                } },
            style = HomeTypography.Name,
            modifier = Modifier
                .padding(top = 24.dp)
        )
        Text(
            text = "오늘의 운세를 알아보아요!",
            style = HomeTypography.Name,
            modifier = Modifier
                .padding(bottom = 24.dp)
        )

            // "오늘의 운세" 타이틀
        Text(
            text = "오늘의 운세",
            style = HomeTypography.Title,
            modifier = Modifier
                .padding(top = 24.dp)
                .padding(bottom = 24.dp)
        )

        LuckCardList(
            sharedViewModel = sharedViewModel,
            cardWidth = 187,  // 카드의 너비 설정
            cardHeight = 232  // 카드의 높이 설정
        )
        Spacer(modifier = Modifier.height(30.dp))  // 30dp 패딩 추가

        LeftTextRightIconButton(
            props = ButtonProps(
                text = "운세 보러가기",
                buttonHeight = 56,
                buttonWidth = 346,
                ),
            onClick = {
                navController.navigate("luck") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
        LeftTextRightIconButton(
            props = ButtonProps(
                text = "타로 보러가기",
                buttonHeight = 56,
                buttonWidth = 346,),
            onClick = {
                navController.navigate("taro") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}

