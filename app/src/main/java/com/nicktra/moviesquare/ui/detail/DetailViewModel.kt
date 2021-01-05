package com.nicktra.moviesquare.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nicktra.moviesquare.data.source.AppRepository
import com.nicktra.moviesquare.data.source.remote.response.movie.DetailMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.DetailShowResponse
import kotlin.properties.Delegates

class DetailViewModel(private val appRepository: AppRepository) : ViewModel() {
    private var movieId by Delegates.notNull<Int>()
    private var showId by Delegates.notNull<Int>()

    fun setSelectedMovie(movieId: Int) {
        this.movieId = movieId
    }

    fun setSelectedShow(showId: Int) {
        this.showId = showId
    }

    fun getDetailMovie(): LiveData<DetailMovieResponse> = appRepository.getDetailMovie(movieId)

    fun getDetailShow(): LiveData<DetailShowResponse> = appRepository.getDetailShow(showId)
}