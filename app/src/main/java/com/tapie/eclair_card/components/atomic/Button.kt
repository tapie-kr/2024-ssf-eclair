package com.tapie.eclair_card.components.atomic

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tapie.eclair_card.R
import com.tapie.eclair_card.ui.theme.GreenColor

data class ButtonProps(
  val text: String,
  val icon: Int?,
  val buttonHeight: Int,
  val buttonWidth: Int
)


@Composable
fun CenteredTextButton(props: ButtonProps, onClick: () -> Unit, modifier: Modifier = Modifier) {
  Button(
    onClick = onClick,
    modifier = Modifier
      .padding(vertical = 4.dp)
      .size(width = props.buttonWidth.dp, height = props.buttonHeight.dp),
    colors = ButtonDefaults.buttonColors(containerColor = GreenColor),
    shape = RoundedCornerShape(8.dp)
  ) {
    Text(
      text = props.text,
      style = TextStyle(
        color = Color.White,
        fontSize = 16.sp
      )
    )
  }
}

@Composable
fun LeftTextRightIconButton(props: ButtonProps, onClick: () -> Unit) {
  Button(
    onClick = onClick,
    modifier = Modifier
      .padding(vertical = 4.dp)
      .size(width = props.buttonWidth.dp, height = props.buttonHeight.dp),
    colors = ButtonDefaults.buttonColors(containerColor = GreenColor),
    shape = RoundedCornerShape(8.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Text(
        text = props.text,
        style = TextStyle(
          color = Color.Black,
          fontSize = 16.sp
        )
      )
      props.icon?.let {
        Image(
          painter = painterResource(id = it),
          contentDescription = null
        )
      }
    }
  }
}