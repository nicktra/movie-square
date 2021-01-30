package com.nicktra.moviesquare.ui.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.data.source.remote.response.tvshow.ResultsShowItem
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
class ShowsViewModelTest {

    private lateinit var viewModel: ShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appRepository: AppRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<ShowEntity>>>

    @Before
    fun setUp() {
        viewModel = ShowsViewModel(appRepository)
    }

    @Test
    fun getShows() {
        val dummyShows = Resource.success(DataDummy.generateDummyShows())
        val shows = MutableLiveData<Resource<List<ShowEntity>>>()
        shows.value = dummyShows

        `when`(appRepository.getAllShows()).thenReturn(shows)
        val showEntities = viewModel.getAllShows().value?.data
        verify(appRepository).getAllShows()
        assertNotNull(showEntities)
        assertEquals(10, showEntities?.size)

        viewModel.getAllShows().observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }
}