package com.vishal2376.scrollblock.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Summary")
data class Summary(
	@PrimaryKey(autoGenerate = true) val summaryId: Int = 0,
	val date: String,
	val totalScrollCount: Int = 0,
	val totalTimeSpent: Int = 0,
	val totalAppOpenCount: Int = 0,
	val totalScrollsBlocked: Int = 0,
	val createdAt: Long = System.currentTimeMillis(),
	val updatedAt: Long = System.currentTimeMillis()
)