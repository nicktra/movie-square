package com.nicktra.moviesquare.data

import com.nicktra.moviesquare.data.source.remote.RemoteDataSource
import com.nicktra.moviesquare.data.source.remote.response.movie.MovieResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.ShowResponse
import com.nicktra.moviesquare.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class AppRepositoryTest {

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val appRepository = FakeAppRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].movieId
    private val showResponses = DataDummy.generateRemoteDummyShows()
    private val showId = showResponses[0].showId

    @Test
    fun getAllMovies() {
        `when`<List<MovieResponse>>(remote.getAllMovies()).thenReturn(movieResponses)
        val movieEntities = appRepository.getAllMovies()
        verify<RemoteDataSource>(remote).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllShows() {
        `when`<List<ShowResponse>>(remote.getAllShows()).thenReturn(showResponses)
        val showEntities = appRepository.getAllShows()
        verify<RemoteDataSource>(remote).getAllShows()
        assertNotNull(showEntities)
        assertEquals(showResponses.size.toLong(), showEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        `when`<List<MovieResponse>>(remote.getAllMovies()).thenReturn(movieResponses)
        val resultMovie = appRepository.getDetailMovie(movieId)
        verify<RemoteDataSource>(remote).getAllMovies()
        assertNotNull(resultMovie)
        assertEquals(movieResponses[0].title, resultMovie.title)
    }

    @Test
    fun getDetailShow() {
        `when`<List<ShowResponse>>(remote.getAllShows()).thenReturn(showResponses)
        val resultShow = appRepository.getDetailShow(showId)
        verify<RemoteDataSource>(remote).getAllShows()
        assertNotNull(resultShow)
        assertEquals(showResponses[0].title, resultShow.title)
    }
}