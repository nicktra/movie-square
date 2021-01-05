package com.nicktra.moviesquare.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nicktra.moviesquare.data.source.AppRepository
import com.nicktra.moviesquare.data.source.remote.response.movie.DetailMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.DetailShowResponse
import com.nicktra.moviesquare.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateRemoteDummyMoviesDetail(464052)
    private val dummyShow = DataDummy.generateRemoteDummyShowsDetail(77169)
    private val movieId = dummyMovie.id
    private val showId = dummyShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var movieObserver: Observer<DetailMovieResponse>

    @Mock
    private lateinit var showObserver: Observer<DetailShowResponse>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(appRepository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedShow(showId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<DetailMovieResponse>()
        movie.value = dummyMovie

        `when`(appRepository.getDetailMovie(movieId)).thenReturn(movie)
        val movieEntity = viewModel.getDetailMovie().value as DetailMovieResponse
        verify(appRepository).getDetailMovie(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.voteAverage, movieEntity.voteAverage, 0.0)

        viewModel.getDetailMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getShow() {
        val show = MutableLiveData<DetailShowResponse>()
        show.value = dummyShow

        `when`(appRepository.getDetailShow(showId)).thenReturn(show)
        val showEntity = viewModel.getDetailShow().value as DetailShowResponse
        verify(appRepository).getDetailShow(showId)
        assertNotNull(showEntity)
        assertEquals(dummyShow.id, showEntity.id)
        assertEquals(dummyShow.name, showEntity.name)
        assertEquals(dummyShow.overview, showEntity.overview)
        assertEquals(dummyShow.posterPath, showEntity.posterPath)
        assertEquals(dummyShow.firstAirDate, showEntity.firstAirDate)
        assertEquals(dummyShow.voteAverage, showEntity.voteAverage, 0.0)

        viewModel.getDetailShow().observeForever(showObserver)
        verify(showObserver).onChanged(dummyShow)
    }

}