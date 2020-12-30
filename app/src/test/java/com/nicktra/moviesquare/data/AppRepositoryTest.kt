package com.nicktra.moviesquare.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.doAnswer
import com.nicktra.moviesquare.data.source.remote.RemoteDataSource

import com.nicktra.moviesquare.utils.DataDummy
import com.nicktra.moviesquare.utils.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class AppRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val appRepository = FakeAppRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].movieId
    private val showResponses = DataDummy.generateRemoteDummyShows()
    private val showId = showResponses[0].showId

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                    .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(appRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadShowsCallback)
                    .onAllShowsReceived(showResponses)
            null
        }.`when`(remote).getAllShows(any())
        val showEntities = LiveDataTestUtil.getValue(appRepository.getAllShows())
        verify(remote).getAllShows(any())
        assertNotNull(showEntities)
        assertEquals(showResponses.size.toLong(), showEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                    .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(appRepository.getDetailMovie(movieId))
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertNotNull(movieEntities.title)
        assertEquals(movieResponses[0].title, movieEntities.title)
    }

    @Test
    fun getDetailShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadShowsCallback)
                    .onAllShowsReceived(showResponses)
            null
        }.`when`(remote).getAllShows(any())
        val showEntities = LiveDataTestUtil.getValue(appRepository.getDetailShow(showId))
        verify(remote).getAllShows(any())
        assertNotNull(showEntities)
        assertNotNull(showEntities.title)
        assertEquals(showResponses[0].title, showEntities.title)
    }
}