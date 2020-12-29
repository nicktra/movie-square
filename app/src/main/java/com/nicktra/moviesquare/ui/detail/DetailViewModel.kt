package com.nicktra.moviesquare.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nicktra.moviesquare.data.MovieEntity
import com.nicktra.moviesquare.data.ShowEntity
import com.nicktra.moviesquare.data.source.AppRepository
import com.nicktra.moviesquare.utils.DataDummy

class DetailViewModel(private val appRepository: AppRepository) : ViewModel() {
    private lateinit var movieId: String
    private lateinit var showId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun setSelectedShow(showId: String) {
        this.showId = showId
    }

    fun getMovie(): LiveData<MovieEntity> = appRepository.getDetailMovie(movieId)

    fun getShow(): LiveData<ShowEntity> = appRepository.getDetailShow(showId)
}