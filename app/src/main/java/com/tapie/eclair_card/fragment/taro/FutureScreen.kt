package com.tapie.eclair_card.fragment.taro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tapie.eclair_card.R
import com.tapie.eclair_card.components.atomic.LogoIcon
import com.tapie.eclair_card.components.atomic.typography.TaroTypography
import com.tapie.eclair_card.data.SharedViewModel
import com.tapie.eclair_card.navigation.Screen

@Composable
fun FutureScreen(navController: NavController, sharedViewModel: SharedViewModel = viewModel()) {
    val futureCardNumber = sharedViewModel.selectedCards.value?.getOrNull(2)

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // 배경색 추가
    ) {
        // 빈 공간을 위한 Box
        Box(
            modifier = Modifier
                .width(50.dp) // 기존 네비게이션 바의 너비만큼 빈 공간을 차지하게 함
                .fillMaxHeight()
        )

        // Content area
        Column(
            modifier = Modifier
                .weight(1f) // 남은 공간을 차지하게 함
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // 세로 중앙 정렬
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp) // 상단의 여백을 최소화
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    IconButton(onClick = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.arrow_back_ios),
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                Text(
                    text = "타로",
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.Center)
                )

                Box(
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    LogoIcon(modifier = Modifier.size(24.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp)) // 상단 텍스트와 카드 사이의 간격

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center, // 세로 중앙 정렬
                modifier = Modifier.fillMaxSize()
            ) {
                // 여기에 선택된 카드 번호에 따른 이미지를 표시
                if (futureCardNumber != null) {
                    val interpretation = DisplayFutureCard(futureCardNumber, Modifier.size(230.dp, 380.dp))
                    Spacer(modifier = Modifier.height(8.dp)) // 빈 공간 조정

                    Text(
                        text = "미래", // 현재에 맞게 수정
                        style = TaroTypography.Time,
                        textAlign = TextAlign.Center, // 텍스트를 가로로 중앙 정렬
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = interpretation,
                        style = TaroTypography.Explain,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}