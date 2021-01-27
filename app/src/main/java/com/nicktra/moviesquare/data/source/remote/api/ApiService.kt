package com.nicktra.moviesquare.data.source.remote.api

import com.nicktra.moviesquare.data.source.remote.response.movie.DetailMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.movie.DiscoverMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.DetailShowResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.DiscoverShowResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("discover/movie")
    fun getAllMovies(@Query("api_key") apiKey: String): Call<DiscoverMovieResponse>

    @GET("movie/{movieId}")
    fun getDetailMovie(
            @Path("movieId") movieId: Int,
            @Query("api_key") apiKey: String
    ): Call<DetailMovieResponse>

    @GET("discover/tv")
    fun getAllShows(@Query("api_key") apiKey: String): Call<DiscoverShowResponse>

    @GET("tv/{showId}")
    fun getDetailShow(
            @Path("showId") showId: Int,
            @Query("api_key") apiKey: String
    ): Call<DetailShowResponse>
}