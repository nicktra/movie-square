package com.nicktra.moviesquare.ui.movies

import androidx.lifecycle.ViewModel
import com.nicktra.moviesquare.data.MovieEntity
import com.nicktra.moviesquare.utils.DataDummy

class MoviesViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovies()
}