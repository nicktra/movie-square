package com.nicktra.moviesquare.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.data.source.remote.response.movie.DetailMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.DetailShowResponse
import com.nicktra.moviesquare.vo.Resource
import kotlin.properties.Delegates

class DetailViewModel(private val appRepository: AppRepository) : ViewModel() {
    val movieId = MutableLiveData<Int>()
    val showId = MutableLiveData<Int>()

    fun setSelectedMovie(movieId: Int) {
        this.movieId.value = movieId
    }

    fun setSelectedShow(showId: Int) {
        this.showId.value = showId
    }

    fun getDetailMovie(): LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { id ->
        appRepository.getDetailMovie(id)
    }

    fun getDetailShow(): LiveData<Resource<ShowEntity>> = Transformations.switchMap(showId) { id ->
        appRepository.getDetailShow(id)
    }
}