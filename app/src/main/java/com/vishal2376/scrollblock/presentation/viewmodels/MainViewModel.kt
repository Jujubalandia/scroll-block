package com.vishal2376.scrollblock.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vishal2376.scrollblock.R
import com.vishal2376.scrollblock.data.local.MainRepository
import com.vishal2376.scrollblock.presentation.home.components.NavDrawerItem
import com.vishal2376.scrollblock.presentation.main.MainEvent
import com.vishal2376.scrollblock.presentation.main.MainState
import com.vishal2376.scrollblock.utils.Constants
import com.vishal2376.scrollblock.utils.SettingsStore
import com.vishal2376.scrollblock.utils.openMail
import com.vishal2376.scrollblock.utils.openUrl
import com.vishal2376.scrollblock.utils.shareApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository, private val store: SettingsStore
) : ViewModel() {

    var appState by mutableStateOf(MainState())

    var todayAppUsageList = repository.getAppUsageByDate(LocalDate.now().toString())

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

                    NavDrawerItem.SOURCE_CODE -> {
                        openUrl(event.context, Constants.REPO_URL)
                    }

                    NavDrawerItem.SHARE_APP -> {
                        shareApp(event.context)
                    }
                }
            }

            is MainEvent.OnToggleInstagram -> {
                viewModelScope.launch {
                    appState = appState.copy(instagramKey = event.isEnabled)
                    store.setInstagramKey(event.isEnabled)
                }
            }

            is MainEvent.OnToggleLinkedin -> {
                viewModelScope.launch {
                    appState = appState.copy(linkedinKey = event.isEnabled)
                    store.setLinkedinKey(event.isEnabled)
                }
            }

            is MainEvent.OnToggleSnapchat -> {
                viewModelScope.launch {
                    store.setSnapchatKey(event.isEnabled)
                    appState = appState.copy(snapchatKey = event.isEnabled)
                }
            }

            is MainEvent.OnToggleYoutube -> {
                viewModelScope.launch {
                    store.setYoutubeKey(!appState.youtubeKey)
                    appState = appState.copy(youtubeKey = !appState.youtubeKey)
                }
            }
        }
    }

    fun loadAppStatus() {
        viewModelScope.launch {
            store.instagramKey.collect {
                appState = appState.copy(instagramKey = it)
            }
        }

        viewModelScope.launch {
            store.youtubeKey.collect {
                appState = appState.copy(youtubeKey = it)
            }
        }

        viewModelScope.launch {
            store.linkedinKey.collect {
                appState = appState.copy(linkedinKey = it)
            }
        }

        viewModelScope.launch {
            store.snapchatKey.collect {
                appState = appState.copy(snapchatKey = it)
            }
        }
    }
}