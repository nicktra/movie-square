package com.nicktra.moviesquare.di

import android.content.Context
import com.nicktra.moviesquare.data.source.AppRepository
import com.nicktra.moviesquare.data.source.remote.RemoteDataSource
import com.nicktra.moviesquare.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AppRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return AppRepository.getInstance(remoteDataSource)
    }
}