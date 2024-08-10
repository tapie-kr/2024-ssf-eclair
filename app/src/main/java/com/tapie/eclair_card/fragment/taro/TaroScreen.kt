package com.tapie.eclair_card.fragment.taro

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.tapie.eclair_card.data.SharedViewModel

@Composable
fun TaroScreen(navController: NavController, sharedViewModel: SharedViewModel = viewModel()){
    val userName by sharedViewModel.userName.observeAsState("")
}