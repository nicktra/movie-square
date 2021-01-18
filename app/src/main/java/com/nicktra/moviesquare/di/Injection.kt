package com.nicktra.moviesquare.di

import android.content.Context
import com.nicktra.moviesquare.data.AppRepository
import com.nicktra.moviesquare.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): AppRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return AppRepository.getInstance(remoteDataSource)
    }
}