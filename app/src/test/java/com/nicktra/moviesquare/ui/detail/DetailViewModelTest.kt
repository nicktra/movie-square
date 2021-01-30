package com.nicktra.moviesquare.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.data.source.remote.response.movie.DetailMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.DetailShowResponse
import com.nicktra.moviesquare.utils.DataDummy
import com.nicktra.moviesquare.vo.Resource
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
    private val dummyMovie = Resource.success(DataDummy.generateDummyMovies()[0])
    private val dummyShow = Resource.success(DataDummy.generateDummyShows()[0])
    private val movieId = dummyMovie.data?.movieId as Int
    private val showId = dummyShow.data?.showId as Int

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var showObserver: Observer<Resource<ShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(appRepository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedShow(showId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie

        `when`(appRepository.getDetailMovie(movieId)).thenReturn(movie)
        /*val movieEntity = viewModel.getDetailMovie.value?.data
        verify(appRepository).getDetailMovie(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.data?.movieId, movieEntity?.movieId)
        assertEquals(dummyMovie.data?.title, movieEntity?.title)
        assertEquals(dummyMovie.data?.overview, movieEntity?.overview)
        assertEquals(dummyMovie.data?.posterPath, movieEntity?.posterPath)
        assertEquals(dummyMovie.data?.releaseDate, movieEntity?.releaseDate)
        assertEquals(dummyMovie.data?.voteAverage.toDouble(), movieEntity?.voteAverage.toDouble(), 0.0)*/

        viewModel.getDetailMovie.observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getShow() {
        val show = MutableLiveData<Resource<ShowEntity>>()
        show.value = dummyShow

        `when`(appRepository.getDetailShow(showId)).thenReturn(show)
        /*val showEntity = viewModel.getDetailShow.value?.data
        verify(appRepository).getDetailShow(showId)
        assertNotNull(showEntity)
        assertEquals(dummyShow.data?.showId, showEntity?.showId)
        assertEquals(dummyShow.data?.name, showEntity?.name)
        assertEquals(dummyShow.data?.overview, showEntity?.overview)
        assertEquals(dummyShow.data?.posterPath, showEntity?.posterPath)
        assertEquals(dummyShow.data?.firstAirDate, showEntity?.firstAirDate)
        assertEquals(dummyShow.data?.voteAverage.toDouble(), showEntity?.voteAverage.toDouble(), 0.0)*/

        viewModel.getDetailShow.observeForever(showObserver)
        verify(showObserver).onChanged(dummyShow)
    }

}