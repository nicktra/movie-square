package com.nicktra.moviesquare.ui.detail

import androidx.lifecycle.ViewModel
import com.nicktra.moviesquare.data.MovieEntity
import com.nicktra.moviesquare.data.ShowEntity
import com.nicktra.moviesquare.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var movieId: String
    private lateinit var showId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun setSelectedShow(showId: String) {
        this.showId = showId
    }

    fun getMovie(): MovieEntity? {
        var movie: MovieEntity? = null
        for (movieEntity in DataDummy.generateDummyMovies()) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }

    fun getShow(): ShowEntity? {
        var show: ShowEntity? = null
        for (showEntity in DataDummy.generateDummyShows()) {
            if (showEntity.showId == showId) {
                show = showEntity
            }
        }
        return show
    }
}