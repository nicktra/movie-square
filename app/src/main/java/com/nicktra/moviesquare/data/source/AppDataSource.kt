package com.nicktra.moviesquare.data.source

import androidx.lifecycle.LiveData
import com.nicktra.moviesquare.data.MovieEntity
import com.nicktra.moviesquare.data.ShowEntity

interface AppDataSource {
    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getAllShows(): LiveData<List<ShowEntity>>

    fun getDetailMovie(movieId: String): LiveData<MovieEntity>

    fun getDetailShow(showId: String): LiveData<ShowEntity>
}