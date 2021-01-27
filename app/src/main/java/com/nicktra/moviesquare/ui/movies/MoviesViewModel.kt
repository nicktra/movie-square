package com.nicktra.moviesquare.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.vo.Resource

class MoviesViewModel(private val appRepository: AppRepository) : ViewModel() {
    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>> = appRepository.getAllMovies()
}