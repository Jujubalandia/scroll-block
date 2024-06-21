package com.vishal2376.scrollblock.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.vishal2376.scrollblock.MainActivity
import com.vishal2376.scrollblock.R

const val CHANNEL_ID = "scrollblock-notification"
const val NOTIFICATION_ID = 200
const val CHANNEL_NAME = "Accessibility Service"

class NotificationHelper(private val context: Context) {

	private val notificationManager =
		context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

	fun buildNotification(): Notification {
		val intent = Intent(context, MainActivity::class.java).apply {
			flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
		}
		val pendingIntent: PendingIntent =
			PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

		return NotificationCompat.Builder(context, CHANNEL_ID)
			.setSmallIcon(R.drawable.ic_notification).setContentTitle("Scroll Block is Active")
			.setContentText("Accessibility Service is running in background")
			.setPriority(NotificationCompat.PRIORITY_DEFAULT).setContentIntent(pendingIntent)
			.setAutoCancel(true).build()
	}

	fun createNotificationChannel() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			val mChannel =
				NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
			notificationManager.createNotificationChannel(mChannel)
		}
	}
}
