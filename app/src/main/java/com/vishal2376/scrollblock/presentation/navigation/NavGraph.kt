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
		navController = navController,
		startDestination = Screen.HomeScreen.name
	) {
		composable(Screen.HomeScreen.name) {
			HomeScreen(allAppUsage)
		}

		composable(Screen.WelcomeScreen.name) {
			WelcomeScreen()
		}

		composable(Screen.PermissionScreen.name) {
			PermissionScreen()
		}
	}
}