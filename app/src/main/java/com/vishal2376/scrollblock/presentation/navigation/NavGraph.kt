package com.vishal2376.scrollblock.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vishal2376.scrollblock.presentation.home.HomeScreen
import com.vishal2376.scrollblock.presentation.onboarding.PermissionScreen
import com.vishal2376.scrollblock.presentation.onboarding.WelcomeScreen
import com.vishal2376.scrollblock.presentation.viewmodels.MainViewModel


@Composable
fun NavGraph(viewModel: MainViewModel) {
	val navController = rememberNavController()

	val allAppUsage by viewModel.appUsageList.collectAsState(initial = emptyList())

	NavHost(
		navController = navController, startDestination = Screen.WelcomeScreen.name
	) {
		composable(Screen.HomeScreen.name) {
			HomeScreen(allAppUsage, onMainEvent = viewModel::onEvent, onNavigate = { route ->
				navController.navigate(route = route)
			})
		}

		composable(Screen.WelcomeScreen.name) {
			WelcomeScreen(onNavigate = { route ->
				navController.navigate(route = route) {
					popUpTo(Screen.WelcomeScreen.name){
						inclusive = true
					}
				}
			})
		}

		composable(Screen.PermissionScreen.name) {
			PermissionScreen(onNavigate = { route ->
				navController.navigate(route = route) {
					popUpTo(Screen.PermissionScreen.name){
						inclusive = true
					}
				}
			})
		}
	}
}