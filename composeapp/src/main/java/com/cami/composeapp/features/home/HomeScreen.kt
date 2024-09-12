package com.cami.composeapp.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cami.composeapp.ui.theme.CamiplaygroundTheme
import timber.log.Timber

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onProductClick: (String) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                viewModel.onChangeCounter(state.counter + 1)
            }
        ) {
            Text("Counter : ${state.counter}")
        }

        Button(
            onClick = {
                onProductClick(state.counter.toString())
            }
        ) {
            Text("Go to product screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    CamiplaygroundTheme {
        HomeScreen { id ->
            Timber.tag("HomePreview").d("Go to product screen with ID: $id")
        }
    }
}
