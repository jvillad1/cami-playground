package com.cami.composeapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cami.composeapp.core.navigation.NavGraph

@Composable
fun ComposeApp(
    modifier: Modifier = Modifier
) {
    ComposeAppBackground(modifier = modifier) {
        NavGraph()
    }
}
