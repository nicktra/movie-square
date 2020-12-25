package com.nicktra.moviesquare.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShowEntity(
        var showId: String,
        var title: String?,
        var overview: String?,
        var image: String?,
        var release: String?,
        var rating: String?
) : Parcelable