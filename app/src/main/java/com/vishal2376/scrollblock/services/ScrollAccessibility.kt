package com.vishal2376.scrollblock.services

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast
import com.vishal2376.scrollblock.utils.NOTIFICATION_ID
import com.vishal2376.scrollblock.utils.NotificationHelper
import com.vishal2376.scrollblock.utils.SupportedApps

class ScrollAccessibility : AccessibilityService() {

	private val supportedApps = listOf(
		SupportedApps.Instagram,
		SupportedApps.Youtube,
		SupportedApps.YoutubeRevanced,
		SupportedApps.YoutubeRevancedExtended,
		SupportedApps.Snapchat
	)

	override fun onServiceConnected() {
		super.onServiceConnected()

		val notificationHelper = NotificationHelper(this@ScrollAccessibility)
		startForeground(NOTIFICATION_ID, notificationHelper.buildNotification())
	}

	override fun onAccessibilityEvent(event: AccessibilityEvent?) {
		event?.let {
			supportedApps.forEach {
				if (event.packageName == it.packageName) {
					// Detect specific Node
					val viewId = "${it.packageName}:id/${it.blockId}"
					val nodeInfo = rootInActiveWindow.findAccessibilityNodeInfosByViewId(viewId)

					if (nodeInfo.isNotEmpty()) {
						// Press Back Button
						performGlobalAction(GLOBAL_ACTION_BACK)

						Toast.makeText(
							this@ScrollAccessibility,
							"Feature Blocked",
							Toast.LENGTH_SHORT
						).show()

					}
				}
			}
		}
	}

	override fun onInterrupt() {
		stopForeground(true)
	}

	override fun onDestroy() {
		super.onDestroy()
		stopForeground(true)
	}
}