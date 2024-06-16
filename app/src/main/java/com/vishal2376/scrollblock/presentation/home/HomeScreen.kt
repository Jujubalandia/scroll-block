package com.vishal2376.scrollblock.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishal2376.scrollblock.R
import com.vishal2376.scrollblock.domain.model.AppInfo
import com.vishal2376.scrollblock.presentation.common.CustomPieChart
import com.vishal2376.scrollblock.presentation.common.descriptionStyle
import com.vishal2376.scrollblock.presentation.common.fontMontserrat
import com.vishal2376.scrollblock.presentation.common.h2style
import com.vishal2376.scrollblock.presentation.home.components.AppInfoComponent
import com.vishal2376.scrollblock.ui.theme.ScrollBlockTheme
import com.vishal2376.scrollblock.ui.theme.blackGradient
import com.vishal2376.scrollblock.ui.theme.blue
import com.vishal2376.scrollblock.ui.theme.white

@Composable
fun HomeScreen(scrollCountList: List<Int>) {
	Scaffold { innerPadding ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(MaterialTheme.colorScheme.primary)
				.padding(innerPadding),
			verticalArrangement = Arrangement.spacedBy(16.dp),
		) {
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.height(400.dp)
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
					// pie chart
					Box(
						modifier = Modifier
							.clip(CircleShape)
							.clickable {
								// todo: navigate to analytics screen
							}, contentAlignment = Alignment.Center
					) {
						Column(horizontalAlignment = Alignment.CenterHorizontally) {
							Text(
								text = scrollCountList.sum().toString(),
								textAlign = TextAlign.Center,
								fontSize = 30.sp,
								fontFamily = fontMontserrat,
							)
							Text(
								text = "scroll",
								textAlign = TextAlign.Center,
								style = descriptionStyle
							)
						}
						CustomPieChart(data = scrollCountList, pieChartSize = 180.dp)
					}

					// pie chart indicator
					Row(
						modifier = Modifier
							.fillMaxWidth(),
						horizontalArrangement = Arrangement.SpaceEvenly
					) {
						// todo: refactor it into single composable
						Row(
							verticalAlignment = Alignment.CenterVertically,
							horizontalArrangement = Arrangement.spacedBy(8.dp)
						) {
							Box(
								modifier = Modifier
									.size(16.dp)
									.background(blue, CircleShape)
							)
							Text("Instagram")
							Text(scrollCountList[0].toString())
						}

						Row(
							verticalAlignment = Alignment.CenterVertically,
							horizontalArrangement = Arrangement.spacedBy(8.dp)
						) {
							Box(
								modifier = Modifier
									.size(16.dp)
									.background(white, CircleShape)
							)
							Text("Youtube")
							Text(scrollCountList[1].toString())
						}
					}

				}

				Button(
					modifier = Modifier
						.align(Alignment.BottomCenter),
					onClick = {
						// todo: implement start/stop service
					},
					colors = ButtonDefaults.buttonColors(
						containerColor = blue,
						contentColor = MaterialTheme.colorScheme.onPrimary
					)
				) {
					Text(
						modifier = Modifier.padding(horizontal = 7.dp, vertical = 4.dp),
						text = "Stop Service",
						fontWeight = FontWeight.Bold,
						fontSize = 16.sp
					)
				}

			}
			Text(
				modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp),
				text = "Supported Apps",
				style = h2style,
				fontWeight = FontWeight.Bold
			)
			Column(
				modifier = Modifier
					.fillMaxWidth()
					.padding(horizontal = 16.dp),
				verticalArrangement = Arrangement.spacedBy(16.dp)
			) {
				val supportedApps = listOf(
					AppInfo(R.drawable.instagram, "Instagram", true),
					AppInfo(R.drawable.youtube, "Youtube", false),
					AppInfo(R.drawable.snapchat, "Snapchat", true),
				)

				supportedApps.forEach {
					AppInfoComponent(app = it, index = supportedApps.indexOf(it)) {
						// todo: implement function to toggle status
					}

				}
			}
		}
	}
}

@Preview
@Composable
private fun HomeScreenPreview() {
	ScrollBlockTheme {
		val scrollCountList = listOf(300, 100)
		HomeScreen(scrollCountList)
	}
}