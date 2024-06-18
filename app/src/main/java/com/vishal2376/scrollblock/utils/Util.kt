package com.vishal2376.scrollblock.utils

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
	allAppUsage: List<AppUsage>,
	packageName: List<String>
): Int {
	return allAppUsage
		.filter { it.packageName in packageName }
		.sumOf { it.scrollCount }
}