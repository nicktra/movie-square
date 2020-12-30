package com.nicktra.moviesquare.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nicktra.moviesquare.data.source.AppDataSource
import com.nicktra.moviesquare.data.source.remote.RemoteDataSource
import com.nicktra.moviesquare.data.source.remote.response.movie.MovieResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.ShowResponse

class FakeAppRepository(private val remoteDataSource: RemoteDataSource) :
    AppDataSource {

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
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
                movieResults.postValue(movieList)
            }
        })

        return movieResults
    }

    override fun getAllShows(): LiveData<List<ShowEntity>> {
        val showResults = MutableLiveData<List<ShowEntity>>()
        remoteDataSource.getAllShows(object : RemoteDataSource.LoadShowsCallback {
            override fun onAllShowsReceived(showResponses: List<ShowResponse>) {
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
                showResults.postValue(showList)
            }
        })

        return showResults
    }

    override fun getDetailMovie(movieId: String): LiveData<MovieEntity> {
        val movieResults = MutableLiveData<MovieEntity>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
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
                movieResults.postValue(movie)
            }
        })

        return movieResults
    }

    override fun getDetailShow(showId: String): LiveData<ShowEntity> {
        val showResults = MutableLiveData<ShowEntity>()
        remoteDataSource.getAllShows(object : RemoteDataSource.LoadShowsCallback {
            override fun onAllShowsReceived(showResponses: List<ShowResponse>) {
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
                showResults.postValue(show)
            }
        })

        return showResults
    }
}