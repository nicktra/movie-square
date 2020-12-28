package com.nicktra.moviesquare.ui.tvshows

import com.nicktra.moviesquare.data.ShowEntity
import com.nicktra.moviesquare.data.source.AppRepository
import com.nicktra.moviesquare.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ShowsViewModelTest {

    private lateinit var viewModel: ShowsViewModel

    @Mock
    private lateinit var appRepository: AppRepository

    @Before
    fun setUp() {
        viewModel = ShowsViewModel(appRepository)
    }

    @Test
    fun getShows() {
        `when`(appRepository.getAllShows()).thenReturn(DataDummy.generateDummyShows() as ArrayList<ShowEntity>)
        val showEntities = viewModel.getShows()
        Mockito.verify(appRepository).getAllShows()
        assertNotNull(showEntities)
        assertEquals(10, showEntities.size)
    }
}