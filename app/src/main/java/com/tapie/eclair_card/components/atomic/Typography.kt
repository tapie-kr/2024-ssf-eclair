package com.tapie.eclair_card.components.atomic


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tapie.eclair_card.R


val Pretendard = FontFamily(
  Font(R.font.pretendard_font_400, FontWeight.W400),
  Font(R.font.pretendard_font_500, FontWeight.W500),
  Font(R.font.pretendard_font_600, FontWeight.W600),
  Font(R.font.pretendard_font_700, FontWeight.W700)
)

// 다양한 텍스트 스타일 정의
val AppTypography = Typography(
  bodyLarge = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
  ),
  labelLarge = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp
  ),
  // 추가 텍스트 스타일 설정
)