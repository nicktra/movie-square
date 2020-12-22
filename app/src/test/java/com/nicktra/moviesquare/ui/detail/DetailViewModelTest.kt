package com.nicktra.moviesquare.ui.detail

import com.nicktra.moviesquare.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyShow = DataDummy.generateDummyShows()[0]
    private val movieId = dummyMovie.movieId
    private val showId = dummyShow.showId

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedShow(showId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.image, movieEntity.image)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.release, movieEntity.release)
        assertEquals(dummyMovie.rating, movieEntity.rating)
    }

    @Test
    fun getShow() {
        viewModel.setSelectedShow(dummyShow.showId)
        val showEntity = viewModel.getShow()
        assertNotNull(showEntity)
        assertEquals(dummyShow.showId, showEntity.showId)
        assertEquals(dummyShow.title, showEntity.title)
        assertEquals(dummyShow.overview, showEntity.overview)
        assertEquals(dummyShow.image, showEntity.image)
        assertEquals(dummyShow.genre, showEntity.genre)
        assertEquals(dummyShow.release, showEntity.release)
        assertEquals(dummyShow.rating, showEntity.rating)
    }

}