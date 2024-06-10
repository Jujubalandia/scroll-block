package com.vishal2376.scrollblock.presentation.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun HomeScreen() {
	Scaffold { innerPadding ->
		Column(Modifier.padding(innerPadding)) {

		}
	}
}

@Preview
@Composable
private fun HomeScreenPreview() {
	HomeScreen()
}