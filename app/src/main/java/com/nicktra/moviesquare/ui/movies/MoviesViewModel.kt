package com.nicktra.moviesquare.ui.movies

import androidx.lifecycle.ViewModel
import com.nicktra.moviesquare.data.MovieEntity
import com.nicktra.moviesquare.data.source.AppRepository
import com.nicktra.moviesquare.utils.DataDummy

class MoviesViewModel(private val appRepository: AppRepository) : ViewModel() {
    fun getMovies(): List<MovieEntity> = appRepository.getAllMovies()
}