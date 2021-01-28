package com.nicktra.moviesquare.ui.favorite.favoritemovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.vo.Resource

class FavoriteMoviesViewModel(private val appRepository: AppRepository) : ViewModel() {
    fun getFavoriteMovies(): LiveData<List<MovieEntity>> = appRepository.getFavoriteMovies()
}