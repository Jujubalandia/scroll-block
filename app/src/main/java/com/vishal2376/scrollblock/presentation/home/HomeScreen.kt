package com.vishal2376.scrollblock.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishal2376.scrollblock.presentation.common.CustomPieChart
import com.vishal2376.scrollblock.presentation.common.descriptionStyle
import com.vishal2376.scrollblock.presentation.common.fontMontserrat
import com.vishal2376.scrollblock.ui.theme.ScrollBlockTheme
import com.vishal2376.scrollblock.ui.theme.blackGradient
import com.vishal2376.scrollblock.ui.theme.blue

@Composable
fun HomeScreen() {
	Scaffold { innerPadding ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(innerPadding)
				.background(MaterialTheme.colorScheme.primary),
		) {
			Column(
				Modifier
					.fillMaxWidth()
					.height(400.dp)
					.clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
					.background(blackGradient),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Center,
			) {
				// pie chart
				Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
					Column(horizontalAlignment = Alignment.CenterHorizontally) {
						Text(
							text = "760",
							textAlign = TextAlign.Center,
							fontSize = 30.sp,
							fontFamily = fontMontserrat,
						)
						Text(
							text = "scrolls",
							textAlign = TextAlign.Center,
							style = descriptionStyle
						)
					}
					CustomPieChart(data = listOf(1300, 500), pieChartSize = 180.dp)
				}

				// pie chart indicato
				Row(
					modifier = Modifier
						.fillMaxWidth()
						.padding(16.dp),
					horizontalArrangement = Arrangement.SpaceEvenly
				) {
					// todo: pie chart indicator
					Text("Instagram")
					Text("Youtube")
				}

				Button(
					modifier = Modifier.align(Alignment.CenterHorizontally).padding(24.dp),
					onClick = { },
					colors = ButtonDefaults.buttonColors(
						containerColor = blue,
						contentColor = MaterialTheme.colorScheme.onPrimary
					)
				) {
					Text(
						modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
						text = "Stop Service",
					)
				}
			}
		}
	}
}

@Preview
@Composable
private fun HomeScreenPreview() {
	ScrollBlockTheme {
		HomeScreen()
	}
}