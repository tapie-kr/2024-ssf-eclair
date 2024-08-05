package com.tapie.eclair_card.components.atomic

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.tapie.eclair_card.ui.theme.BlackColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextInput(
  modifier: Modifier = Modifier,
  value: String,
  onValueChange: (String) -> Unit,
  hint: String = "",
  hintStyle: TextStyle = TextStyle(color = Color.Gray),
  textColor: Color = BlackColor,
  backgroundColor: Color = Color(0xFFDCDCDC)
) {
  Box(
    modifier = modifier
      .background(color = backgroundColor, shape = RoundedCornerShape(8.dp))
      //.padding(8.dp)
      .fillMaxWidth()
  ) {
    OutlinedTextField(
      value = value,
      onValueChange = {
        onValueChange(it)
        Log.d("CustomTextInput", "Input: $it")
      },
      textStyle = TextStyle(color = textColor),
      placeholder = { Text(text = hint, style = hintStyle) },
      colors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color.Transparent,
        unfocusedBorderColor = Color.Transparent,
        containerColor = backgroundColor,
        cursorColor = textColor,
      ),
      modifier = Modifier.fillMaxWidth()
    )
  }
}