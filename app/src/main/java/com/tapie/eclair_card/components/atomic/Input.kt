package com.tapie.eclair_card.components.atomic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
    TextField(
      value = textState.value,
      onValueChange = {
        textState.value = it
        onTextChanged(it.text)
      },
      placeholder = { Text(text = hint) },
      colors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
      )
    )
  }
}

