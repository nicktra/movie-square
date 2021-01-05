package com.nicktra.moviesquare.data.source.remote

import android.util.Log
import com.nicktra.moviesquare.BuildConfig
import com.nicktra.moviesquare.data.source.remote.api.ApiConfig
import com.nicktra.moviesquare.data.source.remote.response.movie.DetailMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.movie.DiscoverMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.movie.ResultsMovieItem
import com.nicktra.moviesquare.data.source.remote.response.tvshow.DetailShowResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.DiscoverShowResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.ResultsShowItem
import com.nicktra.moviesquare.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    private val service = ApiConfig.getApiService()

    companion object {
        const val API_KEY = BuildConfig.API_KEY_TMDB
        val TAG = RemoteDataSource::class.simpleName

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource()
                }
    }

    fun getAllMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()

        service.getAllMovies(API_KEY).enqueue(object : Callback<DiscoverMovieResponse> {
            override fun onResponse(
                    call: Call<DiscoverMovieResponse>,
                    response: Response<DiscoverMovieResponse>,
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val data = responseBody?.results
                    data?.let { callback.onAllMoviesReceived(it) }

                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DiscoverMovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getAllShows(callback: LoadShowsCallback) {
        EspressoIdlingResource.increment()

        service.getAllShows(API_KEY).enqueue(object : Callback<DiscoverShowResponse> {
            override fun onResponse(
                    call: Call<DiscoverShowResponse>,
                    response: Response<DiscoverShowResponse>,
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val data = responseBody?.results
                    data?.let { callback.onAllShowsReceived(it) }

                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DiscoverShowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }


    fun getMovieDetails(movieId: Int, callback: LoadDetailMovieCallback) {
        EspressoIdlingResource.increment()

        service.getDetailMovies(movieId, API_KEY).enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(
                    call: Call<DetailMovieResponse>,
                    response: Response<DetailMovieResponse>,
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    responseBody?.let { callback.onDetailMovieReceived(it) }

                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getShowDetails(showId: Int, callback: LoadDetailShowCallback) {
        EspressoIdlingResource.increment()

        service.getDetailShow(showId, API_KEY)
                .enqueue(object : Callback<DetailShowResponse> {
                    override fun onResponse(
                            call: Call<DetailShowResponse>,
                            response: Response<DetailShowResponse>,
                    ) {
                        if (response.isSuccessful) {
                            val responseBody = response.body()
                            responseBody?.let { callback.onDetailShowReceived(it) }

                            EspressoIdlingResource.decrement()
                        } else {
                            Log.e(TAG, "onFailure: ${response.message()}")
                        }
                    }

                    override fun onFailure(call: Call<DetailShowResponse>, t: Throwable) {
                        Log.e(TAG, "onFailure: ${t.message.toString()}")
                    }
                })
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<ResultsMovieItem>)
    }

    interface LoadShowsCallback {
        fun onAllShowsReceived(showResponses: List<ResultsShowItem>)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieReceived(detailMovieResponses: DetailMovieResponse)
    }

    interface LoadDetailShowCallback {
        fun onDetailShowReceived(detailShowResponses: DetailShowResponse)
    }
}