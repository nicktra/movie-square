package com.nicktra.moviesquare.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
        var movieId: String?,
        var title: String?,
        var overview: String?,
        var image: String?,
        var genre: String?,
        var release: String?,
        var rating: String?
) : Parcelable