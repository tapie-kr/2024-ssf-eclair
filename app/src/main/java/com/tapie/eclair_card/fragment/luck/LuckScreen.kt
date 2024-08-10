package com.tapie.eclair_card.fragment.luck

import LuckCardList
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tapie.eclair_card.R
import com.tapie.eclair_card.components.atomic.LogoIcon
import com.tapie.eclair_card.components.atomic.typography.LuckTypography
import com.tapie.eclair_card.components.icon.GetIcon
import com.tapie.eclair_card.data.SharedViewModel
import com.tapie.eclair_card.navigation.Screen
import com.tapie.eclair_card.ui.theme.GreenColor

@Composable
fun LuckScreen(navController: NavController, sharedViewModel: SharedViewModel = viewModel()) {
    val num by sharedViewModel.num.observeAsState("")
    val icon = GetIcon(num)
    val fourIdioms by sharedViewModel.fourIdioms.observeAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Center everything horizontally
    ) {
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
                text = "운세",
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.Center)
            )

            Box(
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                LogoIcon(modifier = Modifier.size(24.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // Add some space between the header and the image

        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(8.dp)) // Add space between the image and the text

//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .background(
//                    color = GreenColor,
//                    shape = RoundedCornerShape(50)
//                )
//                .padding(horizontal = 16.dp, vertical = 4.dp)
//        ) {
//            Text(
//                text = fourIdioms,
//                style = LuckTypography.Luck_four_idioms,
//                //modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
//            )
//        }

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.wrapContentSize()
        ) {
            // 둥근 사각형 배경
            Box(
                modifier = Modifier
                    .height(12.dp) // 텍스트 크기의 절반
                    .width(96.dp)
                    .background(color = GreenColor, shape = RoundedCornerShape(50))
                    .align(Alignment.BottomCenter) // 가운데 정렬
            )

            // 텍스트
            Text(
                text = fourIdioms,
                style = LuckTypography.Luck_four_idioms
            )
        }

        Spacer(modifier = Modifier.height(20.dp))  // 30dp 패딩 추가

        LuckCardList(
            sharedViewModel = sharedViewModel,
            cardWidth = 250,  // 카드의 너비 설정
            cardHeight = 320  // 카드의 높이 설정
        )
    }
}