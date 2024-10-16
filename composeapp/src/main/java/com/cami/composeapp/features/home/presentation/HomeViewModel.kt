package com.cami.composeapp.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cami.composeapp.features.home.domain.ObserveTopRatedMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import timber.log.Timber
import javax.inject.Inject

const val STATE_FLOW_STARTED_TIME = 5000L

@HiltViewModel
class HomeViewModel @Inject constructor(
    observeTopRatedMovies: ObserveTopRatedMovies
) : ViewModel() {

    val state: StateFlow<HomeState> = observeTopRatedMovies.invoke()
        .filterNotNull()
        .map { movies ->
            HomeState(
                movies = movies,
            )
        }
        .catch { error ->
            Timber.d("Error: ${error.localizedMessage}")
            event.emit(HomeEvent.LoadMoviesError(error.localizedMessage.orEmpty()))
        }
        .stateIn(
            scope = viewModelScope,
            started = WhileSubscribed(STATE_FLOW_STARTED_TIME),
            initialValue = HomeState()
        )

    var event: MutableSharedFlow<HomeEvent> = MutableSharedFlow(replay = 0)
        private set
}
