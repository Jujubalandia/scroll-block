package com.vishal2376.scrollblock.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vishal2376.scrollblock.R
import com.vishal2376.scrollblock.data.local.MainRepository
import com.vishal2376.scrollblock.domain.model.AppUsage
import com.vishal2376.scrollblock.presentation.home.components.NavDrawerItem
import com.vishal2376.scrollblock.presentation.main.MainEvent
import com.vishal2376.scrollblock.utils.openMail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

	var appUsageList = repository.getAllAppUsage()

	// Main App Events
	fun onEvent(event: MainEvent) {
		when (event) {
			is MainEvent.OnClickNavDrawerItem -> {
				when (event.item) {
					NavDrawerItem.REPORT_BUGS -> {
						openMail(event.context, event.context.getString(R.string.report_bugs))
					}

					NavDrawerItem.SUGGESTIONS -> {
						openMail(event.context, event.context.getString(R.string.suggestions))
					}
				}
			}
		}
	}


	fun insertAppUsage(appUsage: AppUsage) {
		viewModelScope.launch {
			repository.insertAppUsage(appUsage)
		}
	}


}