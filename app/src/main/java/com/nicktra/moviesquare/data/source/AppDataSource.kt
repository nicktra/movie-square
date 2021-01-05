package com.nicktra.moviesquare.data.source

import androidx.lifecycle.LiveData
import com.nicktra.moviesquare.data.MovieEntity
import com.nicktra.moviesquare.data.ShowEntity
import com.nicktra.moviesquare.data.source.remote.response.movie.DetailMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.movie.ResultsMovieItem
import com.nicktra.moviesquare.data.source.remote.response.tvshow.DetailShowResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.ResultsShowItem

interface AppDataSource {
    fun getAllMovies(): LiveData<List<ResultsMovieItem>>

    fun getAllShows(): LiveData<List<ResultsShowItem>>

    fun getDetailMovie(movieId: Int): LiveData<DetailMovieResponse>

    fun getDetailShow(showId: Int): LiveData<DetailShowResponse>
}