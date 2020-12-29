package com.nicktra.moviesquare.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nicktra.moviesquare.data.ShowEntity
import com.nicktra.moviesquare.data.source.AppRepository
import com.nicktra.moviesquare.utils.DataDummy

class ShowsViewModel(private val appRepository: AppRepository) : ViewModel() {
    fun getShows(): LiveData<List<ShowEntity>> = appRepository.getAllShows()
}