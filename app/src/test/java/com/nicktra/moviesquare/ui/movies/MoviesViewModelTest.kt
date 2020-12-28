package com.nicktra.moviesquare.ui.movies

import com.nicktra.moviesquare.data.MovieEntity
import com.nicktra.moviesquare.data.source.AppRepository
import com.nicktra.moviesquare.utils.DataDummy
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Mock
    private lateinit var appRepository: AppRepository

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(appRepository)
    }

    @Test
    fun getMovies() {
        `when`(appRepository.getAllMovies()).thenReturn(DataDummy.generateDummyMovies() as ArrayList<MovieEntity>)
        val movieEntities = viewModel.getMovies()
        verify(appRepository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }
}