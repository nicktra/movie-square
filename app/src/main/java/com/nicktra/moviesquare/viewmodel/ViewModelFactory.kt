package com.nicktra.moviesquare.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.di.Injection
import com.nicktra.moviesquare.ui.detail.DetailViewModel
import com.nicktra.moviesquare.ui.favorite.favoritemovies.FavoriteMoviesViewModel
import com.nicktra.moviesquare.ui.favorite.favoritetvshows.FavoriteShowsViewModel
import com.nicktra.moviesquare.ui.movies.MoviesViewModel
import com.nicktra.moviesquare.ui.tvshows.ShowsViewModel

class ViewModelFactory private constructor(private val mAppRepository: AppRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context))
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(ShowsViewModel::class.java) -> {
                return ShowsViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteMoviesViewModel::class.java) -> {
                return FavoriteMoviesViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteShowsViewModel::class.java) -> {
                return FavoriteShowsViewModel(mAppRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}