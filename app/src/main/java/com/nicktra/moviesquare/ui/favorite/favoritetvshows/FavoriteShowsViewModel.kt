package com.nicktra.moviesquare.ui.favorite.favoritetvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity

class FavoriteShowsViewModel (private val appRepository: AppRepository) : ViewModel() {
    fun getFavoriteShows(): LiveData<List<ShowEntity>> = appRepository.getFavoriteShows()
}