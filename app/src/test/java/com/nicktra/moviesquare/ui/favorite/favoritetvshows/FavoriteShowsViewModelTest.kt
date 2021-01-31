package com.nicktra.moviesquare.ui.favorite.favoritetvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
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
class FavoriteShowsViewModelTest {

    private lateinit var viewModel: FavoriteShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var observer: Observer<List<ShowEntity>>

    @Before
    fun setUp() {
        viewModel = FavoriteShowsViewModel(appRepository)
    }

    @Test
    fun getFavoriteShows() {
        val dummyFavoriteShows = DataDummy.generateDummyShows()
        val favoriteShows = MutableLiveData<List<ShowEntity>>()
        favoriteShows.value = dummyFavoriteShows

        Mockito.`when`(appRepository.getFavoriteShows()).thenReturn(favoriteShows)
        val showEntities = viewModel.getFavoriteShows().value
        Mockito.verify(appRepository).getFavoriteShows()
        Assert.assertNotNull(showEntities)
        Assert.assertEquals(10, showEntities?.size)

        viewModel.getFavoriteShows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyFavoriteShows)
    }
}