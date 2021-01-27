package com.nicktra.moviesquare.di

import android.content.Context
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.local.LocalDataSource
import com.nicktra.moviesquare.data.source.local.room.CatalogueDatabase
import com.nicktra.moviesquare.data.source.remote.RemoteDataSource
import com.nicktra.moviesquare.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): AppRepository {

        val database = CatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.catalogueDao())
        val appExecutors = AppExecutors()

        return AppRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}