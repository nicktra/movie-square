package com.nicktra.moviesquare.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nicktra.moviesquare.data.source.remote.RemoteDataSource
import com.nicktra.moviesquare.data.source.remote.response.movie.DetailMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.movie.ResultsMovieItem
import com.nicktra.moviesquare.data.source.remote.response.tvshow.DetailShowResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.ResultsShowItem

class AppRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    AppDataSource {

    companion object {
        @Volatile
        private var instance: AppRepository? = null
        fun getInstance(remoteData: RemoteDataSource): AppRepository =
                instance ?: synchronized(this) {
                    instance ?: AppRepository(remoteData)
                }
    }

    override fun getAllMovies(): LiveData<List<ResultsMovieItem>> {
        val movieResults = MutableLiveData<List<ResultsMovieItem>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<ResultsMovieItem>) {
                movieResults.postValue(movieResponses)
            }
        })
        return movieResults
    }

    override fun getAllShows(): LiveData<List<ResultsShowItem>> {
        val showResults = MutableLiveData<List<ResultsShowItem>>()
        remoteDataSource.getAllShows(object : RemoteDataSource.LoadShowsCallback {
            override fun onAllShowsReceived(showResponses: List<ResultsShowItem>) {
                showResults.postValue(showResponses)
            }
        })
        return showResults
    }

    override fun getDetailMovie(movieId: Int): LiveData<DetailMovieResponse> {
        val movieDetails = MutableLiveData<DetailMovieResponse>()
        remoteDataSource.getMovieDetails(movieId, object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMovieReceived(detailMovieResponses: DetailMovieResponse) {
                movieDetails.postValue(detailMovieResponses)
            }
        })
        return movieDetails
    }

    override fun getDetailShow(showId: Int): LiveData<DetailShowResponse> {
        val showDetails = MutableLiveData<DetailShowResponse>()
        remoteDataSource.getShowDetails(showId, object : RemoteDataSource.LoadDetailShowCallback {
            override fun onDetailShowReceived(detailShowResponses: DetailShowResponse) {
                showDetails.postValue(detailShowResponses)
            }
        })
        return showDetails
    }
}