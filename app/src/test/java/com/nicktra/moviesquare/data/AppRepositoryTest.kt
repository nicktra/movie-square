package com.nicktra.moviesquare.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nicktra.moviesquare.data.source.local.LocalDataSource
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.data.source.remote.RemoteDataSource
import com.nicktra.moviesquare.utils.AppExecutors

import com.nicktra.moviesquare.utils.DataDummy
import com.nicktra.moviesquare.utils.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class AppRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val appRepository = FakeAppRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].id
    private val movieDetails = DataDummy.generateRemoteDummyMoviesDetail(movieId)

    private val showResponses = DataDummy.generateRemoteDummyShows()
    private val showId = showResponses[0].id
    private val showDetails = DataDummy.generateRemoteDummyShowsDetail(showId)

    @Test
    fun getAllMovies() {
        val dummyMovies = MutableLiveData<List<MovieEntity>>()
        dummyMovies.value = DataDummy.generateDummyMovies()
        `when`(local.getAllMovies()).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtil.getValue(appRepository.getAllMovies())
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllShows() {
        val dummyShows = MutableLiveData<List<ShowEntity>>()
        dummyShows.value = DataDummy.generateDummyShows()
        `when`(local.getAllShows()).thenReturn(dummyShows)

        val showEntities = LiveDataTestUtil.getValue(appRepository.getAllShows())
        verify(local).getAllShows()
        assertNotNull(showEntities.data)
        assertEquals(showResponses.size.toLong(), showEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyDetailMovie = MutableLiveData<MovieEntity>()
        dummyDetailMovie.value = DataDummy.generateDummyMovies()[0]
        `when`(local.getMovieById(movieId)).thenReturn(dummyDetailMovie)

        val movieEntities = LiveDataTestUtil.getValue(appRepository.getDetailMovie(movieId))
        verify(local).getMovieById(movieId)
        assertNotNull(movieEntities.data)
        assertNotNull(movieEntities.data?.title)
        assertEquals(movieResponses[0].title, movieEntities.data?.title)
    }

    @Test
    fun getDetailShow() {
        val dummyDetailShow = MutableLiveData<ShowEntity>()
        dummyDetailShow.value = DataDummy.generateDummyShows()[0]
        `when`(local.getShowById(showId)).thenReturn(dummyDetailShow)

        val showEntities = LiveDataTestUtil.getValue(appRepository.getDetailShow(showId))
        verify(local).getShowById(showId)
        assertNotNull(showEntities.data)
        assertNotNull(showEntities.data?.name)
        assertEquals(showResponses[0].name, showEntities.data?.name)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyMovies = MutableLiveData<List<MovieEntity>>()
        dummyMovies.value = DataDummy.generateDummyMovies()
        `when`(local.getFavoriteMovies()).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtil.getValue(appRepository.getFavoriteMovies())
        verify(local).getFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getFavoriteShows() {
        val dummyShows = MutableLiveData<List<ShowEntity>>()
        dummyShows.value = DataDummy.generateDummyShows()
        `when`(local.getFavoriteShows()).thenReturn(dummyShows)

        val showEntities = LiveDataTestUtil.getValue(appRepository.getFavoriteShows())
        verify(local).getFavoriteShows()
        assertNotNull(showEntities)
        assertEquals(showResponses.size.toLong(), showEntities.size.toLong())
    }
}