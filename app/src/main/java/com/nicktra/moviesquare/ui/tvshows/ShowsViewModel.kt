package com.nicktra.moviesquare.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.vo.Resource

class ShowsViewModel(private val appRepository: AppRepository) : ViewModel() {
    fun getAllShows(): LiveData<Resource<List<ShowEntity>>> = appRepository.getAllShows()
}