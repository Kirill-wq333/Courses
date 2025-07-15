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
import com.example.courses.ui.feature.presintashion.favourite.ui.FavouriteScreen
import com.example.courses.ui.feature.presintashion.favourite.viewmodel.FavouriteViewModel
import com.example.courses.ui.feature.presintashion.home.ui.HomeScreen
import com.example.courses.ui.feature.presintashion.home.viewmodel.HomeViewModel
import com.example.courses.ui.feature.presintashion.onboarding.ui.OnboardingScreen
import com.example.courses.ui.feature.presintashion.register.ui.RegistrationScreen

@Composable
fun NavigationBuilder(
    navController: NavHostController,
    visibleBottomBar: (Boolean) -> Unit,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = AppRouts.ONBOARDING,
        modifier = Modifier
            .padding(paddingValues)
            .background(Color.Black)
    ){
        composable(route = AppRouts.ENTRANCE) {
            EntranceScreen(
                openHomeScreen = {
                    navController.navigate(AppRouts.HOME)
                    visibleBottomBar(true)
                },
                openRegistrationScreen = { navController.navigate(AppRouts.REGISTER) }
            )
        }

        composable(route = AppRouts.HOME) {
            val vmHome = hiltViewModel<HomeViewModel>()
            HomeScreen(
                vm = vmHome
            )
        }

        composable(route = AppRouts.FAVOURITE) {
            val vmFavourite = hiltViewModel<FavouriteViewModel>()
            FavouriteScreen(
                vm = vmFavourite
            )
        }
        composable(route = AppRouts.ONBOARDING) {
            OnboardingScreen(
                openRegisterScreen = { navController.navigate(AppRouts.REGISTER) }
            )
        }

        composable(route = AppRouts.REGISTER) {
            RegistrationScreen(
                openEntranceScreen = { navController.navigate(AppRouts.ENTRANCE) },
                openHomeScreen = {
                    navController.navigate(AppRouts.HOME)
                    visibleBottomBar(true)
                }
            )
        }

    }
}