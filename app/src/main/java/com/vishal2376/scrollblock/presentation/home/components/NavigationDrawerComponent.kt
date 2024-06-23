package com.vishal2376.scrollblock.presentation.home.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishal2376.scrollblock.R
import com.vishal2376.scrollblock.presentation.common.fontRoboto
import com.vishal2376.scrollblock.presentation.common.h2style
import com.vishal2376.scrollblock.presentation.main.MainEvent

@Composable
fun NavigationDrawerComponent(onMainEvent: (MainEvent) -> Unit) {

	val context = LocalContext.current

	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier
			.fillMaxHeight()
			.fillMaxWidth(0.8f)
			.padding(vertical = 64.dp)
	) {

		Spacer(modifier = Modifier.height(50.dp))
		Column(horizontalAlignment = Alignment.CenterHorizontally) {
			Image(
				painter = painterResource(R.drawable.app_logo),
				contentDescription = null,
				modifier = Modifier.size(64.dp),
			)
			Spacer(modifier = Modifier.height(16.dp))
			Text(
				text = stringResource(R.string.app_name),
				style = h2style,
				color = MaterialTheme.colorScheme.onPrimary
			)
			Text(
				text = "v1.0-beta",
				fontFamily = fontRoboto,
				fontSize = 15.sp,
				fontWeight = FontWeight.Bold,
				color = MaterialTheme.colorScheme.onPrimary
			)
		}

		Divider(
			modifier = Modifier.padding(top = 24.dp, bottom = 16.dp),
			color = MaterialTheme.colorScheme.secondary,
			thickness = 2.dp
		)

		Column {
			NavDrawerItem.entries.forEach {
				NavDrawerItemUI(icon = it.icon, label = stringResource(id = it.stringId)) {
					onMainEvent(MainEvent.OnClickNavDrawerItem(context, it))
				}
				Spacer(modifier = Modifier.height(8.dp))
			}
		}
	}

}

@Composable
fun NavDrawerItemUI(icon: ImageVector, label: String, onClick: () -> Unit) {
	Row(modifier = Modifier
		.fillMaxWidth()
		.clickable { onClick() }
		.padding(32.dp, 8.dp),
		horizontalArrangement = Arrangement.spacedBy(16.dp),
		verticalAlignment = Alignment.CenterVertically) {
		Icon(
			modifier = Modifier.size(28.dp),
			imageVector = icon,
			contentDescription = null,
			tint = MaterialTheme.colorScheme.onPrimary
		)
		Text(
			text = label,
			style = h2style,
			fontWeight = FontWeight.Bold,
			color = MaterialTheme.colorScheme.onPrimary
		)
	}
}

@Preview(widthDp = 350)
@Composable
fun NavigationDrawerComponentPreview() {
	NavigationDrawerComponent({})
}