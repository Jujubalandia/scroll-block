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

fun getAppTimeSpent(
    allAppUsage: List<AppUsage>, packageName: List<String>
): Int {
    return allAppUsage.filter { it.packageName in packageName }.sumOf { it.timeSpent }
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

fun formatTime(seconds: Int): String {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60

    return when {
        hours > 0 && minutes > 0 -> "${hours}h ${minutes}m"
        hours > 0 -> "${hours}h"
        minutes > 0 -> "${minutes}m"
        else -> "0m"
    }
}
