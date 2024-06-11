package com.vishal2376.scrollblock.presentation.home.components

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vishal2376.scrollblock.R
import com.vishal2376.scrollblock.domain.model.AppInfo
import com.vishal2376.scrollblock.presentation.common.h2style
import com.vishal2376.scrollblock.ui.theme.ScrollBlockTheme
import com.vishal2376.scrollblock.ui.theme.blue
import com.vishal2376.scrollblock.ui.theme.white

@Composable
fun AppInfoComponent() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.clip(RoundedCornerShape(16.dp))
			.background(MaterialTheme.colorScheme.secondary)
			.padding(16.dp),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.spacedBy(16.dp)
	) {
		val app = AppInfo(
			icon = R.drawable.instagram,
			name = "Instagram",
			status = true
		)
		val isEnabled by remember { mutableStateOf(app.status) }

		Image(
			painter = painterResource(id = app.icon), contentDescription = null,
			modifier = Modifier.size(48.dp)
		)
		Text(
			modifier = Modifier.weight(1f),
			text = app.name,
			style = h2style,
			color = MaterialTheme.colorScheme.onPrimary
		)
		Switch(colors = SwitchDefaults.colors(checkedTrackColor = white, checkedThumbColor = blue),
			checked = isEnabled, onCheckedChange = {
//			toggleStatus()
			})
	}
}

@Preview
@Composable
private fun AppInfoComponentPreview() {
	ScrollBlockTheme {
		AppInfoComponent()
	}
}