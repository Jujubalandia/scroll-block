package com.vishal2376.scrollblock.di

import android.content.Context
import androidx.room.Room
import com.vishal2376.scrollblock.data.local.AppDatabase
import com.vishal2376.scrollblock.data.local.AppUsageDao
import com.vishal2376.scrollblock.data.local.MainRepository
import com.vishal2376.scrollblock.data.local.SummaryDao
import com.vishal2376.scrollblock.utils.SettingsStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
	@Provides
	@Singleton
	fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
		return Room.databaseBuilder(
			context.applicationContext,
			AppDatabase::class.java,
			"scrollblock_db"
		).build()
	}

	@Provides
	@Singleton
	fun provideAppUsageDao(database: AppDatabase): AppUsageDao {
		return database.appUsageDao()
	}

	@Provides
	@Singleton
	fun provideSummaryDao(database: AppDatabase): SummaryDao {
		return database.summaryDao()
	}

	@Provides
	@Singleton
	fun provideMainRepository(appUsageDao: AppUsageDao, summaryDao: SummaryDao): MainRepository {
		return MainRepository(appUsageDao, summaryDao)
	}

	@Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideSettingsStore(context: Context): SettingsStore {
        return SettingsStore(context)
    }
}
