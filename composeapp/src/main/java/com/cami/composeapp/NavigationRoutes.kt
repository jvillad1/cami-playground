package com.cami.composeapp

import kotlinx.serialization.Serializable

sealed interface NavRoute

@Serializable
data object HomeRoute : NavRoute

@Serializable
data class ProductRoute(val productId: String) : NavRoute
