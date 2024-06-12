package com.vishal2376.scrollblock.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vishal2376.scrollblock.presentation.home.HomeScreen
import com.vishal2376.scrollblock.presentation.onboarding.PermissionScreen
import com.vishal2376.scrollblock.presentation.onboarding.WelcomeScreen


@Composable
fun NavGraph() {
	val navController = rememberNavController()

	NavHost(
		navController = navController,
		startDestination = Screen.HomeScreen.name
	) {
		composable(Screen.HomeScreen.name) {
			HomeScreen()
		}

		composable(Screen.WelcomeScreen.name) {
			WelcomeScreen()
		}

		composable(Screen.PermissionScreen.name) {
			PermissionScreen()
		}
	}
}