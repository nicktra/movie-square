package com.nicktra.moviesquare.ui.favorite.favoritetvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity

class FavoriteShowsViewModel (private val appRepository: AppRepository) : ViewModel() {
    fun getFavoriteShows(): LiveData<PagedList<ShowEntity>> = appRepository.getFavoriteShows()

    fun setFavoriteShows(showEntity: ShowEntity) {
        val newState = !showEntity.isFavorite
        appRepository.setShowFavorite(showEntity, newState)
    }
}