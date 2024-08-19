package com.tapie.eclair_card.fragment.taro

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tapie.eclair_card.R
import com.tapie.eclair_card.components.atomic.ButtonProps
import com.tapie.eclair_card.components.atomic.CardBack
import com.tapie.eclair_card.components.atomic.CenteredTextButton
import com.tapie.eclair_card.components.atomic.LogoIcon
import com.tapie.eclair_card.components.atomic.TextButton
import com.tapie.eclair_card.components.atomic.typography.TaroTypography
import com.tapie.eclair_card.data.SharedViewModel
import com.tapie.eclair_card.navigation.Screen
import com.tapie.eclair_card.ui.theme.LightPurpleColor
import kotlin.random.Random

@Composable
fun TaroScreen(navController: NavController, sharedViewModel: SharedViewModel = viewModel()) {
    // 상태 변수: 선택된 카드 번호들 (최대 3개까지)
    var selectedCards by remember { mutableStateOf(listOf<Int>()) }

    LaunchedEffect(Unit) {
        sharedViewModel.resetTarotSelection()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
            //.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            // Header section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
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
        }

        item {
            // Circular card layout with drag instruction
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Column 내부의 요소들을 가로 중앙에 배치
                ) {
                    // Drag indicator image (now centered horizontally)
                    Image(
                        painter = painterResource(id = R.drawable.drag),
                        contentDescription = "Drag Indicator",
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .width(155.dp)
                            .height(23.dp)
                    )

                    // Drag instruction text
                    // "드래그 해주세요" 문구는 유지
                    Text(
                        text = "드래그 해주세요.",
                        style = TaroTypography.TaroExplain,
                        color = LightPurpleColor,
                        textAlign = TextAlign.Center
                    )


                    Spacer(modifier = Modifier.height(20.dp))

                    // LazyRow for Circular Card Layout
                    LazyRow(
                        modifier = Modifier.padding(top = 20.dp), // LazyRow를 아래로 내림
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(horizontal = 32.dp)
                    ) {
                        items(22) { index ->
                            CardBack(
                                modifier = Modifier
                                    .size(150.dp, 225.dp)  // 카드 크기 조정
                                    .graphicsLayer(
                                        rotationZ = 0f,
                                        transformOrigin = TransformOrigin(0.5f, 0.5f)
                                    )
                                    .clickable {
                                        // 카드 클릭 시 랜덤한 숫자 선택
                                        val randomNumber = Random.nextInt(0, 22)
                                        if (selectedCards.size < 3 && randomNumber !in selectedCards) {
                                            sharedViewModel.addSelectedCard(randomNumber)
                                            selectedCards = sharedViewModel.selectedCards.value ?: listOf()
                                        }
                                    }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    if (selectedCards.size < 3) {
                        Text(
                            text = "카드를 세 장 골라주세요!",
                            style = TaroTypography.TaroExplain,
                            color = LightPurpleColor,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    selectedCards.forEach { cardNumber ->
                        DisplayCard(cardNumber, Modifier.size(101.dp, 165.dp))
                    }
                }

                // 결과 보기 버튼을 표시
                if (selectedCards.size == 3) {
                    Spacer(modifier = Modifier.height(20.dp))

                    TextButton(
                        props = ButtonProps(text = "결과 보기", buttonWidth = 345, buttonHeight = 53),
                        onClick = { navController.navigate(Screen.Past.route) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun TaroScreenPreview() {
    // 가짜 NavController와 SharedViewModel을 생성합니다.
    val navController = rememberNavController()
    val sharedViewModel = SharedViewModel().apply {
        // 필요한 경우 초기 상태를 설정할 수 있습니다.
        setSelectedCards(listOf(1, 2)) // 가짜 데이터 설정
    }

    TaroScreen(navController = navController, sharedViewModel = sharedViewModel)
}

