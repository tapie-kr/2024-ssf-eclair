package com.tapie.eclair_card.components.atomic

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tapie.eclair_card.R

@Composable
fun LogoIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.logo),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}

@Composable
fun LoadingIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.loading),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}

@Composable
fun HomeIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.home),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}

@Composable
fun HomeChosenIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.home_chose),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}

@Composable
fun LuckIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.luck),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}

@Composable
fun LuckChosenIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.luck_chose),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}

@Composable
fun TaroIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.taro),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}

@Composable
fun TaroChosenIcon(modifier: Modifier = Modifier) {
  Image(
    painter = painterResource(id = R.drawable.taro_chose),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}


@Composable
fun PastIcon(modifier: Modifier= Modifier){
  Image(
    painter = painterResource(id = R.drawable.past),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}

@Composable
fun PastChoseIcon(modifier: Modifier= Modifier){
  Image(
    painter = painterResource(id = R.drawable.past_chose),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}

@Composable
fun PresentIcon(modifier: Modifier= Modifier){
  Image(
    painter = painterResource(id = R.drawable.present),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}

@Composable
fun PresentChoseIcon(modifier: Modifier= Modifier){
  Image(
    painter = painterResource(id = R.drawable.present_chose),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}

@Composable
fun FutureIcon(modifier: Modifier= Modifier){
  Image(
    painter = painterResource(id = R.drawable.future),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}

@Composable
fun FutureChoseIcon(modifier: Modifier= Modifier){
  Image(
    painter = painterResource(id = R.drawable.future_chose),
    contentDescription = null,
    modifier = modifier.size(30.dp)
  )
}

@Preview(showBackground = true)
@Composable
fun IconPreview() {
  Column {
    LogoIcon()
    LoadingIcon()
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