package com.nicktra.moviesquare.data.source

import com.nicktra.moviesquare.data.MovieEntity
import com.nicktra.moviesquare.data.ShowEntity

interface AppDataSource {
    fun getAllMovies(): List<MovieEntity>

    fun getAllShows(): List<ShowEntity>

    fun getDetailMovie(movieId: String): MovieEntity

    fun getDetailShow(showId: String): ShowEntity
}