package com.nicktra.moviesquare.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nicktra.moviesquare.data.MovieEntity
import com.nicktra.moviesquare.data.ShowEntity
import com.nicktra.moviesquare.data.source.AppRepository
import com.nicktra.moviesquare.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
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

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>

    @Mock
    private lateinit var showObserver: Observer<ShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(appRepository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedShow(showId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(appRepository.getDetailMovie(movieId)).thenReturn(movie)
        val movieEntity = viewModel.getMovie().value as MovieEntity
        verify(appRepository).getDetailMovie(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.image, movieEntity.image)
        assertEquals(dummyMovie.release, movieEntity.release)
        assertEquals(dummyMovie.rating, movieEntity.rating)

        viewModel.getMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getShow() {
        val show = MutableLiveData<ShowEntity>()
        show.value = dummyShow

        `when`(appRepository.getDetailShow(showId)).thenReturn(show)
        val showEntity = viewModel.getShow().value as ShowEntity
        verify(appRepository).getDetailShow(showId)
        assertNotNull(showEntity)
        assertEquals(dummyShow.showId, showEntity.showId)
        assertEquals(dummyShow.title, showEntity.title)
        assertEquals(dummyShow.overview, showEntity.overview)
        assertEquals(dummyShow.image, showEntity.image)
        assertEquals(dummyShow.release, showEntity.release)
        assertEquals(dummyShow.rating, showEntity.rating)

        viewModel.getShow().observeForever(showObserver)
        verify(showObserver).onChanged(dummyShow)
    }

}