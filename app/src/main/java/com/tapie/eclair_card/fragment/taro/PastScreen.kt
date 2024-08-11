package com.tapie.eclair_card.fragment.taro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tapie.eclair_card.R
import com.tapie.eclair_card.components.atomic.LogoIcon
import com.tapie.eclair_card.components.atomic.typography.TaroTypography
import com.tapie.eclair_card.components.nav.LengthNavigationBar
import com.tapie.eclair_card.data.SharedViewModel
import com.tapie.eclair_card.navigation.Screen

@Composable
fun PastScreen(navController: NavController, sharedViewModel: SharedViewModel = viewModel()) {

    val pastCardNumber = sharedViewModel.selectedCards.value?.getOrNull(0)

    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        // 나머지 화면 요소들
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // 여기에 선택된 카드 번호에 따른 이미지를 표시
                    if (pastCardNumber != null) {
                        DisplayCard(pastCardNumber, Modifier.size(230.dp, 380.dp))
                    }
                    Spacer(modifier = Modifier.height(8.dp)) // 빈 공간 조정

                    Text(
                        text = "과거", // 선택된 카드에 따라 텍스트 변경 가능
                        style = TaroTypography.Time
                    )

                    Spacer(modifier = Modifier.height(4.dp)) // 빈 공간 조정

                    Text(
                        text = "여기에 타로 해석 써줘용", // 선택된 카드에 따라 텍스트 변경 가능
                        style = TaroTypography.Explain
                    )
                }
        }
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun PastScreenPreview() {
    val navController = rememberNavController()
    val sharedViewModel = SharedViewModel().apply {
        setSelectedCards(listOf(1, 2, 3)) // 가짜 데이터 설정
    }

    PastScreen(navController = navController, sharedViewModel = sharedViewModel)
}