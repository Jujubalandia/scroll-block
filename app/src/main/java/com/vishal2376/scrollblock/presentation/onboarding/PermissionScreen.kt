package com.vishal2376.scrollblock.presentation.onboarding


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vishal2376.scrollblock.R
import com.vishal2376.scrollblock.presentation.common.h1style
import com.vishal2376.scrollblock.presentation.common.smallDescriptionStyle
import com.vishal2376.scrollblock.presentation.common.titleStyle
import com.vishal2376.scrollblock.presentation.navigation.Screen
import com.vishal2376.scrollblock.ui.theme.ScrollBlockTheme
import com.vishal2376.scrollblock.ui.theme.blackGradient
import com.vishal2376.scrollblock.ui.theme.blue
import com.vishal2376.scrollblock.ui.theme.white

@Composable
fun PermissionScreen(onNavigate: (String) -> Unit) {
	Scaffold(floatingActionButton = {
		FloatingActionButton(
			onClick = {
				onNavigate(Screen.HomeScreen.name)
			},
			shape = CircleShape,
			containerColor = blue,
			contentColor = MaterialTheme.colorScheme.onPrimary
		) {
			Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
		}
	}) { innerPadding ->
		Column(
			Modifier
				.fillMaxSize()
				.padding(innerPadding)
				.background(blackGradient),
			verticalArrangement = Arrangement.spacedBy(16.dp)
		) {
			Text(text = "Enable Permissions", style = titleStyle, color = white)
			Text(text = "Accessibility Service", style = h1style, color = blue)
			Text(text = stringResource(R.string.service_desc), style = smallDescriptionStyle)
		}
	}
}

@Preview
@Composable
private fun PermissionScreenPreview() {
	ScrollBlockTheme {
		PermissionScreen({})
	}
}