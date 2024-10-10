package com.cami.composeapp.features.home.presentation

import com.cami.composeapp.features.home.domain.GetTopRatedMovies
import com.cami.composeapp.features.home.domain.Movie
import com.cami.composeapp.utils.MainDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @MockK
    private lateinit var getTopRatedMovies: GetTopRatedMovies

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        homeViewModel = HomeViewModel(getTopRatedMovies)
    }

    @Test
    fun `when getTopRatedMovies is success`() = runTest {
        val topRatedMovies = listOf<Movie>()
        coEvery { getTopRatedMovies.invoke() } returns Result.success(
            emptyList()
        )

        val uiState = homeViewModel.state

        Assert.assertEquals(topRatedMovies, uiState.value.movies)
    }
}
