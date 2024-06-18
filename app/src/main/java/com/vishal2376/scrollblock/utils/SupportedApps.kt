package com.vishal2376.scrollblock.utils

import com.vishal2376.scrollblock.BuildConfig

sealed class SupportedApps(val packageName: String, val blockId: String) {
	data object Instagram : SupportedApps("com.instagram.android", BuildConfig.INSTAGRAM_ID)
	data object Youtube : SupportedApps("com.google.android.youtube", BuildConfig.YOUTUBE_ID)
	data object Linkedin : SupportedApps("com.linkedin.android", BuildConfig.LINKEDIN_ID)
	data object Snapchat : SupportedApps("com.snapchat.android", BuildConfig.SNAPCHAT_ID)

	data object YoutubeRevanced :
		SupportedApps("app.revanced.android.youtube", BuildConfig.YOUTUBE_ID)

	data object YoutubeRevancedExtended :
		SupportedApps("app.rvx.android.youtube", BuildConfig.YOUTUBE_ID)

}