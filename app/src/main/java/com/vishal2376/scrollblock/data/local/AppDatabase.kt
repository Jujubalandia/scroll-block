package com.vishal2376.scrollblock.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vishal2376.scrollblock.domain.model.AppUsage
import com.vishal2376.scrollblock.domain.model.Summary

@Database(entities = [AppUsage::class, Summary::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
	abstract fun appUsageDao(): AppUsageDao
	abstract fun summaryDao(): SummaryDao
}