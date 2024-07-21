package com.tapie.eclair_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tapie.eclair_card.components.atomic.ButtonProps
import com.tapie.eclair_card.components.atomic.CenteredTextButton
import com.tapie.eclair_card.components.atomic.LeftTextRightIconButton
import com.tapie.eclair_card.ui.theme.Eclair_cardTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      Eclair_cardTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
          )
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  Eclair_cardTheme {

    val buttonProps1 = ButtonProps(text = "타로", icon = null, buttonHeight = 60, buttonWidth = 250)
    val buttonProps2 = ButtonProps(text = "타로 보러가기dfasfaf", icon = R.drawable.arrow_forward_ios, buttonHeight = 60, buttonWidth = 250)

    Column(
      modifier = Modifier.padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      CenteredTextButton(props = buttonProps1, onClick = { /* TODO: 버튼 클릭 시 동작 */ })
      LeftTextRightIconButton(props = buttonProps2, onClick = { /* TODO: 버튼 클릭 시 동작 */ })
    }
  }
}