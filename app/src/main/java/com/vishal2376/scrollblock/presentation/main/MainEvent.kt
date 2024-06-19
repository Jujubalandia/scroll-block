package com.vishal2376.scrollblock.presentation.main

import android.content.Context
import com.vishal2376.scrollblock.presentation.home.components.NavDrawerItem

sealed class MainEvent {
	data class OnClickNavDrawerItem(val context: Context, val item: NavDrawerItem) : MainEvent()
}