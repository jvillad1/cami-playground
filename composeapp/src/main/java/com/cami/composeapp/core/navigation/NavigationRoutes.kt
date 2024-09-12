package com.cami.composeapp.core.navigation

import kotlinx.serialization.Serializable

sealed interface NavRoute

@Serializable
data object HomeRoute : NavRoute

@Serializable
data class ProductRoute(val productId: String) : NavRoute
