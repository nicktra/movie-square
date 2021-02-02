package com.nicktra.moviesquare.ui.favorite.favoritetvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
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
class FavoriteShowsViewModelTest {

    private lateinit var viewModel: FavoriteShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var observer: Observer<PagedList<ShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<ShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteShowsViewModel(appRepository)
    }

    @Test
    fun getFavoriteShows() {
        val dummyFavoriteShows = pagedList
        `when`(dummyFavoriteShows.size).thenReturn(10)
        val favoriteShows = MutableLiveData<PagedList<ShowEntity>>()
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