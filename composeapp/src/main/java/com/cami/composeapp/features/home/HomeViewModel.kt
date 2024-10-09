package com.cami.composeapp.features.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    var state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
        private set

    fun onChangeCounter(counterValue: Int) {
        state.update {
            it.copy(
                counter = counterValue
            )
        }
    }
}
