package com.vishal2376.scrollblock.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vishal2376.scrollblock.presentation.homescreen.HomeScreen


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
	}
}