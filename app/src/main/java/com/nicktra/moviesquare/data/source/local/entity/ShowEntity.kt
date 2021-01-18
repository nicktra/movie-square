package com.nicktra.moviesquare.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "showentities")
data class ShowEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "showId")
        var showId: Int,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "overview")
        var overview: String,

        @ColumnInfo(name = "posterPath")
        var posterPath: String,

        @ColumnInfo(name = "firstAirDate")
        var firstAirDate: String,

        @ColumnInfo(name = "voteAverage")
        var voteAverage: Double,

        @ColumnInfo(name = "isFavorite")
        var isFavorite: Boolean
)