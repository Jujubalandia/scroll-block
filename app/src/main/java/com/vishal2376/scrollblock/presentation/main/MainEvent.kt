package com.vishal2376.scrollblock.presentation.main

import android.content.Context
import com.vishal2376.scrollblock.presentation.home.components.NavDrawerItem

sealed class MainEvent {
	data class OnToggleInstagram(val isEnabled: Boolean) : MainEvent()
	data class OnToggleYoutube(val isEnabled: Boolean) : MainEvent()
	data class OnToggleLinkedin(val isEnabled: Boolean) : MainEvent()
	data class OnToggleSnapchat(val isEnabled: Boolean) : MainEvent()
	data class OnClickNavDrawerItem(val context: Context, val item: NavDrawerItem) : MainEvent()
}