package com.cami.composeapp.features.home.data

import com.cami.composeapp.features.home.domain.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val id: Int? = null,
    @SerialName("original_title")
    val originalTitle: String? = null,
    val overview: String? = null,
    val popularity: Double? = null
)

fun MovieResponse.mapToDomain(): Movie = Movie(
    id = id ?: error("id cannot be null"),
    originalTitle = originalTitle ?: error("originalTitle cannot be null"),
    overview = overview ?: error("overview cannot be null"),
    popularity = popularity ?: error("popularity cannot be null"),
)
