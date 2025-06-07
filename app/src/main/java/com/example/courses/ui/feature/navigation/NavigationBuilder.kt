package com.example.courses.ui.feature.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.courses.ui.feature.approuts.AppRouts
import com.example.courses.ui.feature.presintashion.entrance.ui.EntranceScreen
import com.example.courses.ui.feature.presintashion.home.ui.HomeScreen
import com.example.courses.ui.feature.presintashion.home.viewmodel.HomeViewModel

@Composable
fun NavigationBuilder(
    navController: NavHostController,
    visibleBottomBar: (Boolean) -> Unit,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = AppRouts.ENTRANCE,
        modifier = Modifier
            .padding(paddingValues)
            .background(Color.Black)
    ){
        composable(route = AppRouts.ENTRANCE) {
            EntranceScreen(
                openHomeScreen = {
                    navController.navigate(AppRouts.HOME)
                    visibleBottomBar(true)
                }
            )
        }

        composable(route = AppRouts.HOME) {
            val vm = hiltViewModel<HomeViewModel>()
            HomeScreen(
                vm = vm
            )
        }

    }
}