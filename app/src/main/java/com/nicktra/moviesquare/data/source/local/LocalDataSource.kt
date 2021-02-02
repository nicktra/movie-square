package com.nicktra.moviesquare.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.data.source.local.room.CatalogueDao

class LocalDataSource private constructor(private val mCatalogueDao: CatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
                INSTANCE ?: LocalDataSource(catalogueDao)
    }

    // Movie
    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mCatalogueDao.getMovies()

    fun insertMovies(movies: List<MovieEntity>) = mCatalogueDao.insertMovies(movies)

    fun getMovieById(movieId: Int): LiveData<MovieEntity> = mCatalogueDao.getMovieById(movieId)

    fun updateMovieById(movie: MovieEntity) = mCatalogueDao.updateMovie(movie)

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> = mCatalogueDao.getFavoriteMovies()

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        mCatalogueDao.updateMovie(movie)
    }

    // Show
    fun getAllShows(): DataSource.Factory<Int, ShowEntity> = mCatalogueDao.getShows()

    fun insertShows(shows: List<ShowEntity>) = mCatalogueDao.insertShows(shows)

    fun getShowById(showId: Int): LiveData<ShowEntity> = mCatalogueDao.getShowById(showId)

    fun updateShowById(show: ShowEntity) = mCatalogueDao.updateShow(show)

    fun getFavoriteShows(): DataSource.Factory<Int, ShowEntity> = mCatalogueDao.getFavoriteShows()

    fun setShowFavorite(show: ShowEntity, newState: Boolean) {
        show.isFavorite = newState
        mCatalogueDao.updateShow(show)
    }

}