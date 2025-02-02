package com.tapie.eclair_card.components.atomic.typography

import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tapie.eclair_card.components.atomic.Pretendard


data class CustomStartTypography(
    val Name: TextStyle,
    val Input: TextStyle,
    val Button: TextStyle
)

val StartTypography = CustomStartTypography(
    Name = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    Input = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp
    ),
    Button = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp
    )
)