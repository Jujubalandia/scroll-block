package com.vishal2376.scrollblock.services

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import com.vishal2376.scrollblock.utils.NOTIFICATION_ID
import com.vishal2376.scrollblock.utils.NotificationHelper
import com.vishal2376.scrollblock.utils.SupportedApps

class ScrollAccessibility : AccessibilityService() {
	private var scrollCount = 0
	private var currentIndex = 0

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

					if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
						Log.d("@@@", "Windows Changed")
					}

					if (nodeInfo.isNotEmpty() && event.eventType == AccessibilityEvent.TYPE_VIEW_SCROLLED) {
						if (currentIndex != event.fromIndex) {
							scrollCount++
							currentIndex = event.fromIndex
							Log.d("@@@", "Scroll Count: $scrollCount")
						}

						// Press Back Button
//						performGlobalAction(GLOBAL_ACTION_BACK)

//						Toast.makeText(
//							this@ScrollAccessibility,
//							"Feature Blocked",
//							Toast.LENGTH_SHORT
//						).show()

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