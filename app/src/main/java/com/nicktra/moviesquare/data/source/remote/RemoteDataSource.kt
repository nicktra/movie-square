package com.nicktra.moviesquare.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nicktra.moviesquare.BuildConfig
import com.nicktra.moviesquare.data.source.remote.api.ApiConfig
import com.nicktra.moviesquare.data.source.remote.response.movie.DetailMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.movie.DiscoverMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.movie.MovieResponse
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

    fun getAllMovies(): LiveData<ApiResponse<List<ResultsMovieItem>>> {
        EspressoIdlingResource.increment()

        val resultMovie = MutableLiveData<ApiResponse<List<ResultsMovieItem>>>()
        service.getAllMovies(API_KEY).enqueue(object : Callback<DiscoverMovieResponse> {
            override fun onResponse(
                    call: Call<DiscoverMovieResponse>,
                    response: Response<DiscoverMovieResponse>,
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val data = responseBody?.results
                    if (data != null) {
                        val movieList = ArrayList<ResultsMovieItem>()
                        for (responseItem in data) {
                            val movie = ResultsMovieItem(
                                    responseItem.id,
                                    responseItem.title,
                                    responseItem.overview,
                                    responseItem.posterPath,
                                    responseItem.releaseDate,
                                    responseItem.voteAverage,
                                    responseItem.popularity
                            )
                            movieList.add(movie)
                        }
                        resultMovie.postValue(ApiResponse.success(movieList))
                        EspressoIdlingResource.decrement()
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DiscoverMovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return resultMovie
    }

    fun getAllShows(): LiveData<ApiResponse<List<ResultsShowItem>>> {
        EspressoIdlingResource.increment()

        val resultShow = MutableLiveData<ApiResponse<List<ResultsShowItem>>>()
        service.getAllShows(API_KEY).enqueue(object : Callback<DiscoverShowResponse> {
            override fun onResponse(
                    call: Call<DiscoverShowResponse>,
                    response: Response<DiscoverShowResponse>,
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val data = responseBody?.results
                    if (data != null) {
                        val showList = ArrayList<ResultsShowItem>()
                        for (responseItem in data) {
                            val show = ResultsShowItem(
                                    responseItem.id,
                                    responseItem.name,
                                    responseItem.overview,
                                    responseItem.posterPath,
                                    responseItem.firstAirDate,
                                    responseItem.voteAverage,
                                    responseItem.popularity
                            )
                            showList.add(show)
                        }
                        resultShow.postValue(ApiResponse.success(showList))
                        EspressoIdlingResource.decrement()
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DiscoverShowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return resultShow
    }

    fun getMovieDetails(movieId: Int): LiveData<ApiResponse<DetailMovieResponse>> {
        EspressoIdlingResource.increment()

        val resultMovieDetail = MutableLiveData<ApiResponse<DetailMovieResponse>>()
        service.getDetailMovie(movieId, API_KEY).enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(
                    call: Call<DetailMovieResponse>,
                    response: Response<DetailMovieResponse>,
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        val movie = DetailMovieResponse(
                                responseBody.id,
                                responseBody.title,
                                responseBody.overview,
                                responseBody.posterPath,
                                responseBody.releaseDate,
                                responseBody.voteAverage,
                                responseBody.popularity
                        )
                        resultMovieDetail.postValue(ApiResponse.success(movie))
                        EspressoIdlingResource.decrement()
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return resultMovieDetail
    }

    fun getShowDetails(showId: Int): LiveData<ApiResponse<DetailShowResponse>> {
        EspressoIdlingResource.increment()

        val resultShowDetail = MutableLiveData<ApiResponse<DetailShowResponse>>()
        service.getDetailShow(showId, API_KEY).enqueue(object : Callback<DetailShowResponse> {
            override fun onResponse(
                    call: Call<DetailShowResponse>,
                    response: Response<DetailShowResponse>,
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        val show = DetailShowResponse(
                                responseBody.id,
                                responseBody.name,
                                responseBody.overview,
                                responseBody.posterPath,
                                responseBody.firstAirDate,
                                responseBody.voteAverage,
                                responseBody.popularity
                        )
                        resultShowDetail.postValue(ApiResponse.success(show))
                        EspressoIdlingResource.decrement()
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DetailShowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return resultShowDetail
    }

}