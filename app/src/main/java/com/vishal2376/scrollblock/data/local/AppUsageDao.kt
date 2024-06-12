package com.vishal2376.scrollblock.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vishal2376.scrollblock.domain.model.AppUsage

@Dao
interface AppUsageDao {
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertAppUsage(appUsage: AppUsage)

	@Query("SELECT * FROM AppUsage WHERE appPackageName = :appPackageName")
	suspend fun getAppUsageByPackageName(appPackageName: String): List<AppUsage>

	@Query("SELECT * FROM AppUsage")
	suspend fun getAllAppUsage(): List<AppUsage>
}
