package com.cami.composeapp.ui.components

const val DEFAULT_ICON_COLOR = "#FFBA1A1A"

data class BannerUiModel(
    val iconColor: String = DEFAULT_ICON_COLOR,
    val title: String,
    val description: String,
)
