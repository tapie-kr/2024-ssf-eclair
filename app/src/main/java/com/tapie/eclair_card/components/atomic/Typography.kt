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

data class CustomTextStyle(
  val title: TextStyle,
  val body: TextStyle,
  val label: TextStyle
)

val appTextStyles = CustomTextStyle(
  title = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.W700,
    fontSize = 24.sp
  ),
  body = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.W500,
    fontSize = 16.sp
  ),
  label = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.W400,
    fontSize = 20.sp
  )

)