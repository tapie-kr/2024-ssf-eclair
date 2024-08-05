package com.tapie.eclair_card.components.atomic.typography


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tapie.eclair_card.components.atomic.Pretendard


data class CustomTaroTypography(
    val Taro: TextStyle,
    val Explain: TextStyle,
    val Choose : TextStyle,
    val Button : TextStyle,
    val Time : TextStyle,
    val TaroExplain : TextStyle
)

val TaroTypography = CustomTaroTypography(
    Taro = TextStyle(
       fontFamily = Pretendard,
       fontWeight = FontWeight.W600,
       fontSize = 16.sp
   ),
    Explain = TextStyle(
       fontFamily = Pretendard,
       fontWeight = FontWeight.W400,
       fontSize = 14.sp
   ),
    Choose = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W400,
        fontSize = 20.sp
    ),
    Button = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp
    ),
    Time = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W700,
        fontSize = 24.sp
    ),
    TaroExplain = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W400,
        fontSize = 20.sp
    )
)