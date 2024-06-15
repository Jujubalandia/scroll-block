package com.vishal2376.scrollblock.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vishal2376.scrollblock.ui.theme.ScrollBlockTheme
import com.vishal2376.scrollblock.ui.theme.blackGradient

@Composable
fun AnalyticScreen() {
	Scaffold { innerPadding ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(MaterialTheme.colorScheme.primary)
				.padding(innerPadding),
			verticalArrangement = Arrangement.spacedBy(16.dp),
		) {
			Column(
				Modifier
					.fillMaxWidth()
					.height(380.dp)
					.padding(top = 24.dp)
					.clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
					.background(blackGradient),
				horizontalAlignment = Alignment.CenterHorizontally,
			) {
			}
		}
	}
}

@Preview
@Composable
private fun AnalyticScreenPreview() {
	ScrollBlockTheme {
		AnalyticScreen()
	}
}