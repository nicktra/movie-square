package com.nicktra.moviesquare.data.source

import com.nicktra.moviesquare.data.MovieEntity
import com.nicktra.moviesquare.data.ShowEntity
import com.nicktra.moviesquare.data.source.remote.RemoteDataSource

class AppRepository private constructor(private val remoteDataSource: RemoteDataSource) : AppDataSource {

    companion object {
        @Volatile
        private var instance: AppRepository? = null
        fun getInstance(remoteData: RemoteDataSource): AppRepository =
                instance ?: synchronized(this) {
                    instance ?: AppRepository(remoteData)
                }
    }

    override fun getAllMovies(): List<MovieEntity> {
        val movieResponses = remoteDataSource.getAllMovies()
        val movieList = ArrayList<MovieEntity>()
        for (response in movieResponses) {
            val movie = MovieEntity(response.movieId,
                    response.title,
                    response.overview,
                    response.image,
                    response.release,
                    response.rating)
            movieList.add(movie)
        }
        return movieList
    }

    override fun getAllShows(): List<ShowEntity> {
        val showResponses = remoteDataSource.getAllShows()
        val showList = ArrayList<ShowEntity>()
        for (response in showResponses) {
            val show = ShowEntity(response.showId,
                    response.title,
                    response.overview,
                    response.image,
                    response.release,
                    response.rating)
            showList.add(show)
        }
        return showList
    }

    override fun getDetailMovie(movieId: String): MovieEntity {
        val movieResponses = remoteDataSource.getAllMovies()
        lateinit var movie: MovieEntity
        for (response in movieResponses) {
            if (response.movieId == movieId) {
                movie = MovieEntity(response.movieId,
                        response.title,
                        response.overview,
                        response.image,
                        response.release,
                        response.rating)
            }
        }
        return movie
    }

    override fun getDetailShow(showId: String): ShowEntity {
        val showResponses = remoteDataSource.getAllShows()
        lateinit var show: ShowEntity
        for (response in showResponses) {
            if (response.showId == showId) {
                show = ShowEntity(response.showId,
                        response.title,
                        response.overview,
                        response.image,
                        response.release,
                        response.rating)
            }
        }
        return show
    }
}