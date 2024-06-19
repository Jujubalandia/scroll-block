package com.vishal2376.scrollblock.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.vishal2376.scrollblock.R
import com.vishal2376.scrollblock.domain.model.AppUsage

val instagramPackage = listOf(SupportedApps.Instagram.packageName)
val linkedinPackage = listOf(SupportedApps.Linkedin.packageName)
val snapchatPackage = listOf(SupportedApps.Snapchat.packageName)
val youtubePackage = listOf(
	SupportedApps.Youtube.packageName,
	SupportedApps.YoutubeRevanced.packageName,
	SupportedApps.YoutubeRevancedExtended.packageName
)

fun getAppScrollCount(
	allAppUsage: List<AppUsage>, packageName: List<String>
): Int {
	return allAppUsage.filter { it.packageName in packageName }.sumOf { it.scrollCount }
}

fun openMail(context: Context, title: String) {
	val subject = "${context.getString(R.string.app_name)}: $title"
	val uriBuilder = StringBuilder("mailto:" + Uri.encode(Constants.EMAIL))
	uriBuilder.append("?subject=" + Uri.encode(subject))
	val uriString = uriBuilder.toString()

	val intentTitle = "Send $title"
	val intent = Intent(Intent.ACTION_SENDTO, Uri.parse(uriString))
	context.startActivity(Intent.createChooser(intent, intentTitle))
}