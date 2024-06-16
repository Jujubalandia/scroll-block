package com.vishal2376.scrollblock.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vishal2376.scrollblock.data.local.MainRepository
import com.vishal2376.scrollblock.domain.model.AppUsage
import com.vishal2376.scrollblock.utils.SupportedApps
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

	var appUsageList = repository.getAllAppUsage()

	fun insertAppUsage(appUsage: AppUsage) {
		viewModelScope.launch {
			repository.insertAppUsage(appUsage)
		}
	}


}