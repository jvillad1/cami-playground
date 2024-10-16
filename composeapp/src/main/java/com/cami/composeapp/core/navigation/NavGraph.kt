package com.cami.composeapp.core.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.cami.composeapp.features.home.presentation.HomeScreen
import com.cami.composeapp.features.movie.MovieScreen

@Composable
fun NavGraph() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val modifier = Modifier
            .padding(innerPadding)
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = HomeRoute
        ) {
            composable<HomeRoute> {
                HomeScreen(
                    modifier = modifier,
                    onMovieClicked = { id ->
                        navController.navigate(route = MovieRoute(id))
                    }
                )
            }

            composable<MovieRoute> { backStackEntry ->
                val product: MovieRoute = backStackEntry.toRoute()

                MovieScreen(
                    modifier = modifier,
                    movieId = product.movieId
                )
            }
        }
    }
}
