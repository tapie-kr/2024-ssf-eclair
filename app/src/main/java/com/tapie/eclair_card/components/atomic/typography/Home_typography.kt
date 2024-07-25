package com.tapie.eclair_card.components.atomic.typography

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tapie.eclair_card.components.atomic.Pretendard

val HomeTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W700,
        fontSize = 24.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp
    )
)


//@Preview(showBackground = true)
//@Composable
//fun HomeTypographyPreview() {
//    MaterialTheme(typography = HomeTypography) {
//        Surface(modifier = Modifier.padding(16.dp)) {
//            Column {
//                Text(text = "김선린님", style = HomeTypography.displayLarge)
//                Text(text = "오늘의 운세를 알아보세요", style = HomeTypography.displayMedium)
//                Text(text = "오늘의 운세", style = HomeTypography.displaySmall)
//                Text(text = "총운/운 이름", style = HomeTypography.headlineMedium)
//                Text(text = "전화위복", style = HomeTypography.titleLarge)
//                Text(text = "운 설명", style = HomeTypography.titleMedium)
//                Text(text = "버튼", style = HomeTypography.labelLarge)
//            }
//        }
//    }
//}