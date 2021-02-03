package com.nicktra.moviesquare.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "movieId")
        var movieId: Int,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "overview")
        var overview: String,

        @ColumnInfo(name = "posterPath")
        var posterPath: String,

        @ColumnInfo(name = "releaseDate")
        var releaseDate: String,

        @ColumnInfo(name = "voteAverage")
        var voteAverage: Double,

        @ColumnInfo(name = "popularity")
        var popularity: Double,

        @ColumnInfo(name = "isFavorite")
        var isFavorite: Boolean
)