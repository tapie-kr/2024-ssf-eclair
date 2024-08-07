package com.tapie.eclair_card.fragment.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tapie.eclair_card.components.atomic.typography.StartTypography
import com.tapie.eclair_card.data.SharedViewModel

@Composable
fun HomeScreen(navController: NavController, sharedViewModel: SharedViewModel = viewModel()) {
    val userName by sharedViewModel.userName.observeAsState("")
    val horoscope by sharedViewModel.horoscope.observeAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "환영합니다, ${userName}님!",
            style = StartTypography.Name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )
        Text(
            text = horoscope,
            style = StartTypography.Name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )
    }
}