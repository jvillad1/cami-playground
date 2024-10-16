package com.cami.composeapp.features.home.presentation

import app.cash.turbine.test
import com.cami.composeapp.features.home.domain.Movie
import com.cami.composeapp.features.home.domain.ObserveTopRatedMovies
import com.cami.composeapp.utils.MainDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @MockK
    private lateinit var observeTopRatedMovies: ObserveTopRatedMovies

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `when getTopRatedMovies is success`() = runTest {
        val topRatedMovies = listOf<Movie>()
        coEvery { observeTopRatedMovies.invoke() } returns flow{
            emit(topRatedMovies)
        }

        homeViewModel = HomeViewModel(observeTopRatedMovies)
        homeViewModel.state.test {
            val uiState = awaitItem()
            Assert.assertEquals(topRatedMovies, uiState.movies)
        }
    }

    @Test
    fun `when getTopRatedMovies is failure`() = runTest {
        val throwable = Throwable("⚠️ Something went wrong")
        coEvery { observeTopRatedMovies.invoke() } returns flow {
            error("⚠️ Something went wrong")
        }

        homeViewModel = HomeViewModel(observeTopRatedMovies)
        homeViewModel.event.test {
            val event = awaitItem() as HomeEvent.LoadMoviesError
            Assert.assertEquals(throwable.localizedMessage, event.message)
        }
    }
}
