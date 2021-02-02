package com.nicktra.moviesquare.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.vo.Resource

interface AppDataSource {
    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllShows(): LiveData<Resource<PagedList<ShowEntity>>>

    fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>>

    fun getDetailShow(showId: Int): LiveData<Resource<ShowEntity>>

    fun setMovieFavorite(movie: MovieEntity, isFavorite: Boolean)

    fun setShowFavorite(show: ShowEntity, isFavorite: Boolean)

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteShows(): LiveData<PagedList<ShowEntity>>
}