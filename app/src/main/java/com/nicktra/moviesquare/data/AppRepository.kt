package com.nicktra.moviesquare.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nicktra.moviesquare.data.source.local.LocalDataSource
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.data.source.remote.ApiResponse
import com.nicktra.moviesquare.data.source.remote.RemoteDataSource
import com.nicktra.moviesquare.data.source.remote.response.movie.DetailMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.movie.ResultsMovieItem
import com.nicktra.moviesquare.data.source.remote.response.tvshow.DetailShowResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.ResultsShowItem
import com.nicktra.moviesquare.utils.AppExecutors
import com.nicktra.moviesquare.vo.Resource

class AppRepository private constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors)
    : AppDataSource {

    companion object {
        @Volatile
        private var instance: AppRepository? = null
        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): AppRepository =
                instance ?: synchronized(this) {
                    instance ?: AppRepository(remoteData, localData, appExecutors)
                }
    }

    override fun getAllMovies(): LiveData<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<ResultsMovieItem>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MovieEntity>> =
                    localDataSource.getAllMovies()

            override fun shouldFetch(data: List<MovieEntity>?): Boolean =
                    data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<ResultsMovieItem>>> =
                    remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<ResultsMovieItem>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                            response.id,
                            response.title,
                            response.overview,
                            response.posterPath,
                            response.releaseDate,
                            response.voteAverage,
                    false)
                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllShows(): LiveData<Resource<List<ShowEntity>>> {
        return object : NetworkBoundResource<List<ShowEntity>, List<ResultsShowItem>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<ShowEntity>> =
                    localDataSource.getAllShows()

            override fun shouldFetch(data: List<ShowEntity>?): Boolean =
                    data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<ResultsShowItem>>> =
                    remoteDataSource.getAllShows()

            public override fun saveCallResult(data: List<ResultsShowItem>) {
                val showList = ArrayList<ShowEntity>()
                for (response in data) {
                    val show = ShowEntity(
                            response.id,
                            response.name,
                            response.overview,
                            response.posterPath,
                            response.firstAirDate,
                            response.voteAverage,
                            false)
                    showList.add(show)
                }

                localDataSource.insertShows(showList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, DetailMovieResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                    localDataSource.getMovieById(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                    data == null

            override fun createCall(): LiveData<ApiResponse<DetailMovieResponse>> =
                    remoteDataSource.getMovieDetails(movieId)

            override fun saveCallResult(data: DetailMovieResponse) {
                val movie = MovieEntity(
                        data.id,
                        data.title,
                        data.overview,
                        data.posterPath,
                        data.releaseDate,
                        data.voteAverage,
                        false)
                localDataSource.updateMovieById(movie)
            }
        }.asLiveData()
    }

    override fun getDetailShow(showId: Int): LiveData<Resource<ShowEntity>> {
        return object : NetworkBoundResource<ShowEntity, DetailShowResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<ShowEntity> =
                    localDataSource.getShowById(showId)

            override fun shouldFetch(data: ShowEntity?): Boolean =
                    data == null

            override fun createCall(): LiveData<ApiResponse<DetailShowResponse>> =
                    remoteDataSource.getShowDetails(showId)

            override fun saveCallResult(data: DetailShowResponse) {
                val show = ShowEntity(
                        data.id,
                        data.name,
                        data.overview,
                        data.posterPath,
                        data.firstAirDate,
                        data.voteAverage,
                        false)
                localDataSource.updateShowById(show)
            }
        }.asLiveData()
    }

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) =
            appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

    override fun setShowFavorite(show: ShowEntity, state: Boolean) =
            appExecutors.diskIO().execute { localDataSource.setShowFavorite(show, state) }
}