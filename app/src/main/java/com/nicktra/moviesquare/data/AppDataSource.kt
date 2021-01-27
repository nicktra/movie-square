package com.nicktra.moviesquare.data

import androidx.lifecycle.LiveData
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.vo.Resource

interface AppDataSource {
    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>>

    fun getAllShows(): LiveData<Resource<List<ShowEntity>>>

    fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>>

    fun getDetailShow(showId: Int): LiveData<Resource<ShowEntity>>

    /*fun setFavoriteMovie(movie: MovieEntity, isFavorite: Boolean)

    fun setFavoriteShow(show: ShowEntity, isFavorite: Boolean)

    fun getFavoriteMovies(): LiveData<List<MovieEntity>>

    fun getFavoriteShows(): LiveData<List<ShowEntity>>*/
}