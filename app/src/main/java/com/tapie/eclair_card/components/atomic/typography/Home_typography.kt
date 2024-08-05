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
import org.w3c.dom.Text

data class CustomHomeTypography(
    val Name: TextStyle,
    val Title: TextStyle,
    val Todayluck : TextStyle,
    val Luck : TextStyle,
    val Luckname : TextStyle,
    val Body: TextStyle,
    val Button: TextStyle
)

val HomeTypography = CustomHomeTypography(
    Name = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W700,
        fontSize = 24.sp
    ),
    Title = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    Todayluck = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),
    Luck = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp
    ),
    Luckname = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
    Body = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
    Button = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp
    )
)

