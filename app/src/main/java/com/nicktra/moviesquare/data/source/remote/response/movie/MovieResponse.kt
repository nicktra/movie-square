package com.nicktra.moviesquare.data.source.remote.response.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    var movieId: String,
    var title: String,
    var overview: String,
    var image: String,
    var release: String,
    var rating: String
) : Parcelable
