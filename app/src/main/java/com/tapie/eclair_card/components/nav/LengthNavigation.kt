package com.tapie.eclair_card.components.nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tapie.eclair_card.components.atomic.*

// 데이터 클래스 정의
data class LengthNavItem(
    val name: String,
    val route: String,
    val icon: @Composable (Modifier) -> Unit,
    val selectedIcon: @Composable (Modifier) -> Unit,
    val label: String
)

// 길이 내비게이션 바 정의
@Composable
fun LengthNavigationBar(navController: NavController) {
    val iconSize = 50.dp // 아이콘 크기 설정
    val items = listOf(
        LengthNavItem("Past", "past", { PastIcon(Modifier.size(iconSize)) }, { PastChoseIcon(Modifier.size(iconSize)) }, "과거"),
        LengthNavItem("Present", "present", { PresentIcon(Modifier.size(iconSize)) }, { PresentChoseIcon(Modifier.size(iconSize)) }, "현재"),
        LengthNavItem("Future", "future", { FutureIcon(Modifier.size(iconSize)) }, { FutureChoseIcon(Modifier.size(iconSize)) }, "미래")
    )

    Box(
        modifier = Modifier
            .fillMaxHeight() // 세로로 화면 전체를 채움
            .width(50.dp)
            .background(Color.White) // 배경색을 설정하여 구분 가능하게 만듦
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight() // 세로로 화면 전체를 채움
                .fillMaxWidth() // 가로로 NavigationRail의 너비를 채움
                .background(Color.White), // 배경색 설정
            verticalArrangement = Arrangement.Center, // 아이템들을 세로 중앙에 배치
            horizontalAlignment = Alignment.CenterHorizontally // 아이템들을 가로 중앙에 배치
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            items.forEachIndexed { index, item ->
                if (index > 0) {
                    Spacer(modifier = Modifier.height(175.dp)) // 아이템 사이의 간격 설정
                }

                NavigationRailItem(
                    icon = {
                        if (currentRoute == item.route) {
                            item.selectedIcon(Modifier) // 크기는 이미 설정되어 있음
                        } else {
                            item.icon(Modifier) // 크기는 이미 설정되어 있음
                        }
                    },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}

// 미리보기 추가
@Preview(showBackground = true, widthDp = 200, heightDp = 600)
@Composable
fun LengthNavigationBarPreview() {
    val navController = rememberNavController() // NavController 생성
    LengthNavigationBar(navController = navController) // 미리보기에 사용할 Composable 호출
}