package com.tapie.eclair_card.components.atomic

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.tapie.eclair_card.R

val Pretendard = FontFamily(
  Font(R.font.pretendard_font_400, FontWeight.W400),
  Font(R.font.pretendard_font_500, FontWeight.W500),
  Font(R.font.pretendard_font_600, FontWeight.W600),
  Font(R.font.pretendard_font_700, FontWeight.W700)
)

// Custom typography definitions
val CustomTypography = Typography(
  displayLarge = TextStyle( // 당신의 이름을 알려주세요
    fontFamily = Pretendard,
    fontWeight = FontWeight.W600,
    fontSize = 24.sp
  ),
  displayMedium = TextStyle( // 로고
    fontFamily = Pretendard,
    fontWeight = FontWeight.W600,
    fontSize = 20.sp
  ),
  displaySmall = TextStyle( // 완료(버튼)
    fontFamily = Pretendard,
    fontWeight = FontWeight.W600,
    fontSize = 18.sp
  ),
  headlineLarge = TextStyle( // 홈 : 김선린님
    fontFamily = Pretendard,
    fontWeight = FontWeight.W700,
    fontSize = 24.sp
  ),
  headlineMedium = TextStyle( // 홈 : 오늘의 운세를 알아보아요
    fontFamily = Pretendard,
    fontWeight = FontWeight.W600,
    fontSize = 24.sp
  ),
  headlineSmall = TextStyle( // 이름 input
    fontFamily = Pretendard,
    fontWeight = FontWeight.W400,
    fontSize = 14.sp
  ),
  titleLarge = TextStyle( // 홈 : 오늘의 운세
    fontFamily = Pretendard,
    fontWeight = FontWeight.W500,
    fontSize = 20.sp
  ),
  titleMedium = TextStyle( // 홈 : 총운, 연애운 등
    fontFamily = Pretendard,
    fontWeight = FontWeight.W600,
    fontSize = 18.sp
  ),
  titleSmall = TextStyle( // 홈 : 운세 설명
    fontFamily = Pretendard,
    fontWeight = FontWeight.W400,
    fontSize = 16.sp
  ),
  bodyLarge = TextStyle( // 홈 : 운세 보러가기/ 타로 보러가기
    fontFamily = Pretendard,
    fontWeight = FontWeight.W600,
    fontSize = 16.sp
  ),
  bodyMedium = TextStyle( // 운세 :  전화위복과 같은 운세 설명
    fontFamily = Pretendard,
    fontWeight = FontWeight.W700,
    fontSize = 24.sp
  ),
  bodySmall = TextStyle( // 운세 설명
    fontFamily = Pretendard,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
  ),
  labelLarge = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp
  ),
  labelMedium = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp
  ),
  labelSmall = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Medium,
    fontSize = 11.sp
  )
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
  MaterialTheme(
    typography = CustomTypography,
    content = content
  )
}

@Preview(showBackground = true)
@Composable
fun TypographyPreview() {
  AppTheme {
    Column {
      Text("This is Display Large Text", style = MaterialTheme.typography.displayLarge)
      Text("This is Headline Large Text", style = MaterialTheme.typography.headlineLarge)
      Text("This is Body Large Text", style = MaterialTheme.typography.bodyLarge)
    }
  }
}