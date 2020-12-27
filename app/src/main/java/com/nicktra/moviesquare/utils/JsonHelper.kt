package com.nicktra.moviesquare.utils

import android.content.Context
import com.nicktra.moviesquare.data.source.remote.response.movie.MovieResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.ShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val movieId = movie.getString("movieId")
                val title = movie.getString("title")
                val overview = movie.getString("overview")
                val image = "https://image.tmdb.org/t/p/w500${movie.getString("image")}"
                val release = movie.getString("release")
                val rating = movie.getString("rating")

                val movieResponse = MovieResponse(movieId, title, overview, image, release, rating)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadShows(): List<ShowResponse> {
        val list = ArrayList<ShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("ShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("shows")
            for (i in 0 until listArray.length()) {
                val show = listArray.getJSONObject(i)

                val showId = show.getString("showId")
                val title = show.getString("title")
                val overview = show.getString("overview")
                val image = "https://image.tmdb.org/t/p/w500${show.getString("image")}"
                val release = show.getString("release")
                val rating = show.getString("rating")

                val showResponse = ShowResponse(showId, title, overview, image, release, rating)
                list.add(showResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}