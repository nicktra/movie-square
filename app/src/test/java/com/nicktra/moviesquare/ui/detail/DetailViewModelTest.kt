package com.nicktra.moviesquare.ui.detail

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
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyShow = DataDummy.generateDummyShows()[0]
    private val movieId = dummyMovie.movieId
    private val showId = dummyShow.showId

    @Mock
    private lateinit var appRepository: AppRepository

    @Before
    fun setUp() {
        viewModel = DetailViewModel(appRepository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedShow(showId)
    }

    @Test
    fun getMovie() {
        `when`(appRepository.getDetailMovie(movieId)).thenReturn(dummyMovie)
        val movieEntity = viewModel.getMovie()
        verify(appRepository).getDetailMovie(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.image, movieEntity.image)
        assertEquals(dummyMovie.release, movieEntity.release)
        assertEquals(dummyMovie.rating, movieEntity.rating)
    }

    @Test
    fun getShow() {
        `when`(appRepository.getDetailShow(showId)).thenReturn(dummyShow)
        val showEntity = viewModel.getShow()
        verify(appRepository).getDetailShow(showId)
        assertNotNull(showEntity)
        assertEquals(dummyShow.showId, showEntity.showId)
        assertEquals(dummyShow.title, showEntity.title)
        assertEquals(dummyShow.overview, showEntity.overview)
        assertEquals(dummyShow.image, showEntity.image)
        assertEquals(dummyShow.release, showEntity.release)
        assertEquals(dummyShow.rating, showEntity.rating)
    }

}