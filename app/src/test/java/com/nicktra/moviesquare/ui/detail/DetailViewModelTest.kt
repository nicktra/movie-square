package com.nicktra.moviesquare.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.utils.DataDummy
import com.nicktra.moviesquare.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = Resource.success(DataDummy.generateDummyMovies()[0])
    private val dummyShow = Resource.success(DataDummy.generateDummyShows()[0])
    private val movieId = dummyMovie.data?.movieId as Int
    private val showId = dummyShow.data?.showId as Int

    private val movieNullId = 20
    private val showNullId = 20

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

        viewModel.getDetailMovie.observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getShow() {
        val show = MutableLiveData<Resource<ShowEntity>>()
        show.value = dummyShow

        `when`(appRepository.getDetailShow(showId)).thenReturn(show)

        viewModel.getDetailShow.observeForever(showObserver)
        verify(showObserver).onChanged(dummyShow)
    }

    @Test(expected = Exception::class)
    fun givenNullMovie_addThrows() {
        doThrow().`when`(appRepository.getDetailMovie(movieNullId))
    }

    @Test(expected = Exception::class)
    fun givenNullShow_addThrows() {
        doThrow().`when`(appRepository.getDetailShow(showNullId))
    }
}