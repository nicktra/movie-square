package com.nicktra.moviesquare.ui.favorite.favoritemovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity

class FavoriteMoviesViewModel(private val appRepository: AppRepository) : ViewModel() {
    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = appRepository.getFavoriteMovies()

    fun setFavoriteMovies(movieEntity: MovieEntity) {
        val newState = !movieEntity.isFavorite
        appRepository.setMovieFavorite(movieEntity, newState)
    }
}