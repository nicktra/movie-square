package com.nicktra.moviesquare.ui.favorite.favoritemovies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteMoviesViewModelTest {

    private lateinit var viewModel: FavoriteMoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteMoviesViewModel(appRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyFavoriteMovies = pagedList
        `when`(dummyFavoriteMovies.size).thenReturn(5)
        val favoriteMovies = MutableLiveData<PagedList<MovieEntity>>()
        favoriteMovies.value = dummyFavoriteMovies

        Mockito.`when`(appRepository.getFavoriteMovies()).thenReturn(favoriteMovies)
        val movieEntities = viewModel.getFavoriteMovies().value
        Mockito.verify(appRepository).getFavoriteMovies()
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(5, movieEntities?.size)

        viewModel.getFavoriteMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyFavoriteMovies)
    }
}