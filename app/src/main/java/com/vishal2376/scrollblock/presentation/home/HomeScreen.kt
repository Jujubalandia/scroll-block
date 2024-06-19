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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishal2376.scrollblock.R
import com.vishal2376.scrollblock.domain.model.AppInfo
import com.vishal2376.scrollblock.domain.model.AppUsage
import com.vishal2376.scrollblock.presentation.common.CustomPieChart
import com.vishal2376.scrollblock.presentation.common.descriptionStyle
import com.vishal2376.scrollblock.presentation.common.fontMontserrat
import com.vishal2376.scrollblock.presentation.common.h2style
import com.vishal2376.scrollblock.presentation.home.components.AppInfoComponent
import com.vishal2376.scrollblock.presentation.home.components.NavigationDrawerComponent
import com.vishal2376.scrollblock.presentation.home.components.ScrollCountIndicatorComponent
import com.vishal2376.scrollblock.presentation.main.MainEvent
import com.vishal2376.scrollblock.ui.theme.ScrollBlockTheme
import com.vishal2376.scrollblock.ui.theme.blackGradient
import com.vishal2376.scrollblock.ui.theme.blue
import com.vishal2376.scrollblock.ui.theme.pieChartColors
import com.vishal2376.scrollblock.utils.SettingsStore
import com.vishal2376.scrollblock.utils.getAppScrollCount
import com.vishal2376.scrollblock.utils.instagramPackage
import com.vishal2376.scrollblock.utils.linkedinPackage
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
	allAppUsage: List<AppUsage>, onNavigate: (String) -> Unit, onMainEvent: (MainEvent) -> Unit
) {

	val context = LocalContext.current
	val scope = rememberCoroutineScope()
	val store = SettingsStore(context)

	val instagramScrollCount = getAppScrollCount(allAppUsage, instagramPackage)
	val linkedinScrollCount = getAppScrollCount(allAppUsage, linkedinPackage)

	val scrollCountList = mapOf(
		"Instagram" to instagramScrollCount, "Linkedin" to linkedinScrollCount
	)

	val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

	ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
		ModalDrawerSheet(drawerContainerColor = MaterialTheme.colorScheme.primary) {
			NavigationDrawerComponent(onMainEvent)
		}
	}) {
		Scaffold(topBar = {
			TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
				containerColor = Color.Transparent
			), title = {
				Text(
					text = stringResource(id = R.string.app_name), style = h2style
				)
			}, navigationIcon = {
				IconButton(onClick = {
					scope.launch {
						drawerState.apply {
							if (isClosed) open() else close()
						}
					}
				}) {
					Icon(
						imageVector = Icons.Default.Menu, contentDescription = null
					)
				}
			})
		}) { innerPadding ->
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
						.height(350.dp)
				) {

					Column(
						Modifier
							.fillMaxWidth()
							.verticalScroll(rememberScrollState())
							.height(330.dp)
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
									text = scrollCountList.values.sum().toString(),
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
							CustomPieChart(
								data = scrollCountList.values.toList(), pieChartSize = 170.dp
							)
						}

						// pie chart indicator
						Row(
							modifier = Modifier.fillMaxWidth(),
							horizontalArrangement = Arrangement.SpaceEvenly
						) {
							scrollCountList.forEach { (appName, scrollCount) ->
								val color = pieChartColors[scrollCountList.keys.indexOf(appName)]
								ScrollCountIndicatorComponent(
									appName = appName, scrollCount = scrollCount, color = color
								)
							}
						}

					}

					Button(
						modifier = Modifier.align(Alignment.BottomCenter), onClick = {
							// todo: implement start/stop service
						}, colors = ButtonDefaults.buttonColors(
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
					text = "Block apps",
					style = h2style,
					fontWeight = FontWeight.Bold
				)
				Column(
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 16.dp),
					verticalArrangement = Arrangement.spacedBy(16.dp)
				) {
					val instagramKey = store.instagramKey.collectAsState(initial = true)
					val youtubeKey = store.youtubeKey.collectAsState(initial = true)
					val linkedinKey = store.linkedinKey.collectAsState(initial = true)
					val snapchatKey = store.snapchatKey.collectAsState(initial = true)

					val supportedApps = listOf(
						AppInfo(R.drawable.instagram, "Instagram Reels", instagramKey.value),
						AppInfo(R.drawable.youtube, "Youtube Shorts", youtubeKey.value),
						AppInfo(R.drawable.linkedin, "Linkedin Video", linkedinKey.value),
						AppInfo(R.drawable.snapchat, "Snapchat Spotlight", snapchatKey.value),
					)

					supportedApps.forEach {
						AppInfoComponent(app = it, index = supportedApps.indexOf(it)) {
							scope.launch {
								when (it.name) {
									"Instagram Reels" -> store.setInstagramKey(!instagramKey.value)
									"Youtube Shorts" -> store.setYoutubeKey(!youtubeKey.value)
									"Linkedin Video" -> store.setLinkedinKey(!linkedinKey.value)
									"Snapchat Spotlight" -> store.setSnapchatKey(!snapchatKey.value)
								}
							}
						}

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
		//create a fake appUsageList
		val appUsageList = listOf(
			AppUsage(packageName = "com.instagram.android", scrollCount = 100),
			AppUsage(packageName = "com.youtube.android", scrollCount = 100),
		)
		HomeScreen(appUsageList, {}, {})
	}
}