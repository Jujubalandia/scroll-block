package com.vishal2376.scrollblock.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "AppUsage")
data class AppUsage(
	@PrimaryKey(autoGenerate = true) val usageId: Int = 0,
	val packageName: String,
	val date: String = LocalDate.now().toString(),
	val scrollCount: Int = 0,
	val timeSpent: Int = 0,
	val appOpenCount: Int = 0,
	val scrollsBlocked: Int = 0,
	val createdAt: Long = System.currentTimeMillis(),
	val updatedAt: Long = System.currentTimeMillis()
)