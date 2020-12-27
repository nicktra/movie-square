package com.nicktra.moviesquare.data.source.remote.response.tvshow

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShowResponse(
    var showId: String,
    var title: String,
    var overview: String,
    var image: String,
    var release: String,
    var rating: String
) : Parcelable
