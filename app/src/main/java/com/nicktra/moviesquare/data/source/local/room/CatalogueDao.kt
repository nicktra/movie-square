package com.nicktra.moviesquare.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity

@Dao
interface CatalogueDao {
    // Movie
    @Query("SELECT * FROM movieentities ORDER BY popularity DESC")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovieById(movieId: Int): LiveData<MovieEntity>

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("SELECT * FROM movieentities where isFavorite = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity>

    // Show
    @Query("SELECT * FROM showentities ORDER BY popularity DESC")
    fun getShows(): DataSource.Factory<Int, ShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShows(shows: List<ShowEntity>)

    @Query("SELECT * FROM showentities WHERE showId = :showId")
    fun getShowById(showId: Int): LiveData<ShowEntity>

    @Update
    fun updateShow(show: ShowEntity)

    @Query("SELECT * FROM showentities where isFavorite = 1")
    fun getFavoriteShows(): DataSource.Factory<Int, ShowEntity>
}