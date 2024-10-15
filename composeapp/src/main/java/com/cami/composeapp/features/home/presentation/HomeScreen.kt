package com.cami.composeapp.features.home.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cami.composeapp.R
import com.cami.composeapp.features.home.domain.Movie
import com.cami.composeapp.ui.components.BannerUiModel
import com.cami.composeapp.ui.components.BannerView
import com.cami.composeapp.ui.theme.ComposeAppTheme
import timber.log.Timber

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onMovieClicked: (String) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val event by viewModel.event.collectAsStateWithLifecycle(initialValue = null)
    val listState = rememberLazyListState()

    HomeScreen(
        modifier = modifier,
        state = state,
        event = event,
        listState = listState,
        onMovieClicked = onMovieClicked
    )
}

@Composable
private fun HomeScreen(
    modifier: Modifier,
    state: HomeState,
    event: HomeEvent?,
    listState: LazyListState,
    onMovieClicked: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        state = listState,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = state.movies, key = { it.id }) { movie ->
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable {
                        onMovieClicked.invoke(movie.id.toString())
                    },
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.onBackground
                )
            ) {
                Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
                    Text(
                        text = movie.originalTitle,
                        modifier = Modifier.padding(bottom = 16.dp),
                        color = Color.White,
                        style = MaterialTheme.typography.headlineMedium,
                    )

                    Text(
                        text = movie.overview,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium,
                    )

                    Text(
                        text = movie.popularity.toString(),
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
    }

    HomeEventHandler(event)
}

@Composable
private fun HomeEventHandler(event: HomeEvent?) {
    when (event) {
        is HomeEvent.LoadMoviesError -> BannerView(
            uiModel = BannerUiModel(
                title = stringResource(R.string.error_title),
                description = event.message
            ),
        )

        null -> Timber.d("no-op")
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    ComposeAppTheme {
        HomeScreen(
            modifier = Modifier,
            state = HomeState(
                movies = listOf(
                    Movie(
                        id = 1,
                        originalTitle = "Movie 1",
                        overview = "Overview 1",
                        popularity = 1.0,
                    )
                )
            ),
            event = null,
            listState = rememberLazyListState()
        ) { id ->
            Timber.tag("HomePreview").d("Go to movie screen with ID: $id")
        }
    }
}
