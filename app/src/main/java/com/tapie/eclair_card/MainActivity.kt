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
import com.tapie.eclair_card.navigation.Navigation
import com.tapie.eclair_card.ui.theme.Eclair_cardTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
         Navigation()
    }
  }
}



