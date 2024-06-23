package com.vishal2376.scrollblock.presentation.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.vishal2376.scrollblock.R

enum class NavDrawerItem(val stringId: Int, val icon: ImageVector) {
	REPORT_BUGS(R.string.report_bugs, Icons.Default.BugReport), SUGGESTIONS(
		R.string.suggestions,
		Icons.AutoMirrored.Filled.Chat
	),
	SOURCE_CODE(R.string.source_code, Icons.Default.Star), SHARE_APP(
		R.string.share_app,
		Icons.Default.Share
	)
}