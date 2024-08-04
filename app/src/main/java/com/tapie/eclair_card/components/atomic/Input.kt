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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.tapie.eclair_card.ui.theme.BlackColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextInput(
  modifier: Modifier = Modifier,
  hint: String = "",
  backgroundColor: Color = Color(0xFFDCDCDC),
  onTextChanged: (String) -> Unit
) {
  val textState = remember { mutableStateOf(TextFieldValue()) }

  Box(
    modifier = modifier
      .background(color = backgroundColor, shape = RoundedCornerShape(8.dp))
      .padding(8.dp)
      .fillMaxWidth()
  ) {
    OutlinedTextField(
      value = textState.value,
      onValueChange = {
        textState.value = it
        onTextChanged(it.text)
        Log.d("CustomTextInput", "Input: ${it.text}") // 로그 출력
        println("Input: ${it.text}") // println으로 출력
      },
      textStyle = TextStyle(color = BlackColor),
      placeholder = { Text(text = hint, color = Color.Gray) },
      colors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color.Transparent,
        unfocusedBorderColor = Color.Transparent,
        containerColor = Color.White,
        cursorColor = BlackColor,
        focusedTextColor = BlackColor,
        unfocusedTextColor = BlackColor
      ),
      modifier = Modifier.fillMaxWidth()
    )

    if (textState.value.text.isEmpty()) {
      Text(
        text = hint,
        style = TextStyle(color = Color.Gray),
        modifier = Modifier.padding(start = 4.dp, top = 8.dp)
      )
    }
  }
}