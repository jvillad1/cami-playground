package com.cami.composeapp.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cami.composeapp.features.home.domain.GetTopRatedMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopRatedMovies: GetTopRatedMovies
) : ViewModel() {

    private var job: Job? = null

    var state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
        private set

    init {
        job?.cancel()
        job = viewModelScope.launch {
            getTopRatedMovies.invoke()
                .onSuccess { movies ->
                    state.update {
                        it.copy(
                            movies = movies
                        )
                    }
                }.onFailure { error ->

                }
        }
    }
}
