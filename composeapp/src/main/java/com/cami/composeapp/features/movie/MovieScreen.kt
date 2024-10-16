package com.cami.composeapp.features.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cami.composeapp.ui.theme.ComposeAppTheme

@Composable
fun MovieScreen(modifier: Modifier = Modifier, movieId: String) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Movie ID: $movieId"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoviePreview() {
    ComposeAppTheme {
        MovieScreen(movieId = "ABC")
    }
}
