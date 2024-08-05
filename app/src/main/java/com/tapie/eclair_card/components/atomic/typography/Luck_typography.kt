package com.tapie.eclair_card.components.atomic.typography

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tapie.eclair_card.components.atomic.Pretendard
import org.w3c.dom.Text

data class CustomLuckTypography(
    val Luck : TextStyle,
    val Luck_four_idioms : TextStyle,
    val LuckName: TextStyle,
    val Body : TextStyle,
    val Button : TextStyle
)

val LuckTypography = CustomLuckTypography(
   Luck = TextStyle(
       fontFamily = Pretendard,
       fontWeight = FontWeight.W600,
       fontSize = 16.sp
   ),
    Luck_four_idioms = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W700,
        fontSize = 24.sp
    ),
    LuckName = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    Body = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W400,
        fontSize = 20.sp
    ),
    Button = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp
    )
)