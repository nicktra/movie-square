package com.nicktra.moviesquare.ui.tvshows

import androidx.lifecycle.ViewModel
import com.nicktra.moviesquare.data.ShowEntity
import com.nicktra.moviesquare.utils.DataDummy

class ShowsViewModel : ViewModel() {
    fun getShows(): List<ShowEntity> = DataDummy.generateDummyShows()
}