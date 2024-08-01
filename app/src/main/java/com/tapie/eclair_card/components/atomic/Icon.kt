package com.tapie.eclair_card.components.atomic

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.tapie.eclair_card.R

@Composable
fun HomeIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.home),
    contentDescription = null,
    modifier = modifier
  )
}

@Composable
fun HomeChosenIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.home_chose),
    contentDescription = null,
    modifier = modifier
  )
}

@Composable
fun LuckIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.luck),
    contentDescription = null,
    modifier = modifier
  )
}

@Composable
fun LuckChosenIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.luck_chose),
    contentDescription = null,
    modifier = modifier
  )
}

@Composable
fun TaroIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.taro),
    contentDescription = null,
    modifier = modifier
  )
}

@Composable
fun TaroChosenIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.taro_chose),
    contentDescription = null,
    modifier = modifier
  )
}


@Composable
fun PastIcon(modifier: Modifier= Modifier){
  Image(
    painter = painterResource(id = R.drawable.past),
    contentDescription = null,
    modifier = modifier
  )
}

@Composable
fun PastChoseIcon(modifier: Modifier= Modifier){
  Image(
    painter = painterResource(id = R.drawable.past_chose),
    contentDescription = null,
    modifier = modifier
  )
}

@Composable
fun PresentIcon(modifier: Modifier= Modifier){
  Image(
    painter = painterResource(id = R.drawable.present),
    contentDescription = null,
    modifier = modifier
  )
}

@Composable
fun PresentChoseIcon(modifier: Modifier= Modifier){
  Image(
    painter = painterResource(id = R.drawable.present_chose),
    contentDescription = null,
    modifier = modifier
  )
}

@Composable
fun FutureIcon(modifier: Modifier= Modifier){
  Image(
    painter = painterResource(id = R.drawable.future),
    contentDescription = null,
    modifier = modifier
  )
}

@Composable
fun FutureChoseIcon(modifier: Modifier= Modifier){
  Image(
    painter = painterResource(id = R.drawable.future_chose),
    contentDescription = null,
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun IconPreview() {
  Column {
    HomeIcon()
    HomeChosenIcon()
    LuckIcon()
    LuckChosenIcon()
    TaroIcon()
    TaroChosenIcon()
    PastIcon()
    PastChoseIcon()
    PresentIcon()
    PresentChoseIcon()
    FutureIcon()
    FutureChoseIcon()
  }
}