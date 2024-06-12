package com.vishal2376.scrollblock.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vishal2376.scrollblock.data.local.AppUsageDao
import com.vishal2376.scrollblock.data.local.SummaryDao
import com.vishal2376.scrollblock.domain.model.AppUsage
import com.vishal2376.scrollblock.domain.model.Summary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val appUsageDao: AppUsageDao,
	private val summaryDao: SummaryDao
) : ViewModel() {

    fun insertAppUsage(appUsage: AppUsage) {
        viewModelScope.launch {
            appUsageDao.insertAppUsage(appUsage)
        }
    }

    fun updateSummary(summary: Summary) {
        viewModelScope.launch {
            summaryDao.updateSummary(summary)
        }
    }
}