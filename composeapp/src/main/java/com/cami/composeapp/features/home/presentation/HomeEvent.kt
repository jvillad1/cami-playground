package com.cami.composeapp.features.home.presentation

sealed class HomeEvent {
    data class LoadMoviesError(val message: String) : HomeEvent()
}
