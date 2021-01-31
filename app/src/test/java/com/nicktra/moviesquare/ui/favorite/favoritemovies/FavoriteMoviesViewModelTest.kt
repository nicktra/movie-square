package com.nicktra.moviesquare.ui.favorite.favoritemovies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.utils.DataDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteMoviesViewModelTest {

    private lateinit var viewModel: FavoriteMoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = FavoriteMoviesViewModel(appRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyFavoriteMovies = DataDummy.generateDummyMovies()
        val favoriteMovies = MutableLiveData<List<MovieEntity>>()
        favoriteMovies.value = dummyFavoriteMovies

        Mockito.`when`(appRepository.getFavoriteMovies()).thenReturn(favoriteMovies)
        val movieEntities = viewModel.getFavoriteMovies().value
        Mockito.verify(appRepository).getFavoriteMovies()
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(10, movieEntities?.size)

        viewModel.getFavoriteMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyFavoriteMovies)
    }
}