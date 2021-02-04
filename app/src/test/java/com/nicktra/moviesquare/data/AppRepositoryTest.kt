package com.nicktra.moviesquare.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.verify
import com.nicktra.moviesquare.data.source.local.LocalDataSource
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.data.source.remote.RemoteDataSource
import com.nicktra.moviesquare.utils.AppExecutors
import com.nicktra.moviesquare.utils.DataDummy
import com.nicktra.moviesquare.utils.LiveDataTestUtil
import com.nicktra.moviesquare.utils.PagedListUtil
import com.nicktra.moviesquare.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*


class AppRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val appRepository = FakeAppRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].id

    private val showResponses = DataDummy.generateRemoteDummyShows()
    private val showId = showResponses[0].id

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        appRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        `when`(local.getAllShows()).thenReturn(dataSourceFactory)
        appRepository.getAllShows()

        val showEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyShows()))
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
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        appRepository.getFavoriteMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        `when`(local.getFavoriteShows()).thenReturn(dataSourceFactory)
        appRepository.getFavoriteShows()

        val showEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyShows()))
        verify(local).getFavoriteShows()
        assertNotNull(showEntities)
        assertEquals(showResponses.size.toLong(), showEntities.data?.size?.toLong())
    }

    //Using doAnswer() for void method
    @Test
    fun getDetailMovieDoAnswer() {
        doAnswer { invocation ->
            val arg0: Any = invocation.arguments[0]

            assertEquals(movieId, arg0)
            null
        }.`when`(local).getMovieById(anyInt())
        local.getMovieById(movieId)
        verify(local, times(1)).getMovieById(movieId)
    }

    //Using doAnswer() for void method
    @Test
    fun getDetailShowDoAnswer() {
        doAnswer { invocation ->
            val arg0: Any = invocation.arguments[0]

            assertEquals(showId, arg0)
            null
        }.`when`(local).getShowById(anyInt())
        local.getShowById(showId)
        verify(local, times(1)).getShowById(showId)
    }

}