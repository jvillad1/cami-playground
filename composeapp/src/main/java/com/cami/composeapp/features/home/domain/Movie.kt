package com.cami.composeapp.features.home.domain

data class Movie(
    val id: Int,
    val originalTitle: String,
    val overview: String,
    val popularity: Double
)
