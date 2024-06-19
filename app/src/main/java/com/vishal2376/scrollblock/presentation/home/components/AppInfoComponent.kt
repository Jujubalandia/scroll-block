package com.vishal2376.scrollblock.presentation.home.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vishal2376.scrollblock.R
import com.vishal2376.scrollblock.domain.model.AppInfo
import com.vishal2376.scrollblock.presentation.common.h3style
import com.vishal2376.scrollblock.ui.theme.ScrollBlockTheme
import com.vishal2376.scrollblock.ui.theme.blue
import com.vishal2376.scrollblock.ui.theme.white
import kotlinx.coroutines.delay

@Composable
fun AppInfoComponent(
	app: AppInfo,
	index: Int,
	toggleStatus: () -> Unit,
) {
	var isVisible by remember { mutableStateOf(false) }

	LaunchedEffect(key1 = Unit) {
		delay(index * 150L)
		isVisible = true
	}

	AnimatedVisibility(
		visible = isVisible,
		enter = slideInVertically(
			initialOffsetY = { -it },
			animationSpec = tween(durationMillis = 500)
		) + fadeIn(animationSpec = tween(durationMillis = 1000))
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.clip(RoundedCornerShape(16.dp))
				.background(MaterialTheme.colorScheme.secondary)
				.padding(12.dp, 8.dp),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.spacedBy(16.dp)
		) {

			var isEnabled by remember { mutableStateOf(app.status) }

			Image(
				painter = painterResource(id = app.icon), contentDescription = null,
				modifier = Modifier.size(40.dp)
			)
			Text(
				modifier = Modifier.weight(1f),
				text = app.name,
				style = h3style,
				color = MaterialTheme.colorScheme.onPrimary
			)
			Switch(modifier = Modifier.scale(0.9f),
				colors = SwitchDefaults.colors(checkedTrackColor = white, checkedThumbColor = blue),
				checked = isEnabled,
				onCheckedChange = {
					toggleStatus()
					isEnabled = !isEnabled
				})
		}
	}
}

@Preview
@Composable
private fun AppInfoComponentPreview() {
	ScrollBlockTheme {
		val app = AppInfo(
			icon = R.drawable.instagram,
			name = "Instagram",
			status = true
		)
		AppInfoComponent(app = app, toggleStatus = {}, index = 1)
	}
}