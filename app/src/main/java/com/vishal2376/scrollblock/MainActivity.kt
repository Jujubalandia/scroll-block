package com.vishal2376.scrollblock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.vishal2376.scrollblock.presentation.navigation.NavGraph
import com.vishal2376.scrollblock.ui.theme.ScrollBlockTheme
import com.vishal2376.scrollblock.utils.NotificationHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()

		// create notification channel
		NotificationHelper(applicationContext).createNotificationChannel()

		setContent {
			ScrollBlockTheme {
				NavGraph()
			}
		}
	}
}
