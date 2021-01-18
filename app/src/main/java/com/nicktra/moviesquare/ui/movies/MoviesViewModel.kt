package com.nicktra.moviesquare.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.remote.response.movie.ResultsMovieItem

class MoviesViewModel(private val appRepository: AppRepository) : ViewModel() {
    fun getAllMovies(): LiveData<List<ResultsMovieItem>> = appRepository.getAllMovies()
}