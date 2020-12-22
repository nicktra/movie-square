package com.nicktra.moviesquare.ui.tvshows

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ShowsViewModelTest {

    private lateinit var viewModel: ShowsViewModel

    @Before
    fun setUp() {
        viewModel = ShowsViewModel()
    }

    @Test
    fun getMovies() {
        val showEntities = viewModel.getShows()
        assertNotNull(showEntities)
        assertEquals(10, showEntities.size)
    }
}