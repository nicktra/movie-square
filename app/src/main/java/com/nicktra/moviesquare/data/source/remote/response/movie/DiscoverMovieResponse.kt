package com.nicktra.moviesquare.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class DiscoverMovieResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<ResultsMovieItem>,

	@field:SerializedName("total_results")
	val totalResults: Int
)

data class ResultsMovieItem(
		@field:SerializedName("id")
		val id: Int,

		@field:SerializedName("title")
		val title: String,

		@field:SerializedName("overview")
		val overview: String,

		@field:SerializedName("poster_path")
		val posterPath: String,

		@field:SerializedName("release_date")
		val releaseDate: String,

		@field:SerializedName("vote_average")
		val voteAverage: Double,

	/*@field:SerializedName("original_language")
	val originalLanguage: String,

	@field:SerializedName("original_title")
	val originalTitle: String,

	@field:SerializedName("video")
	val video: Boolean,

	@field:SerializedName("genre_ids")
	val genreIds: List<Int>,

	@field:SerializedName("backdrop_path")
	val backdropPath: String,

	@field:SerializedName("popularity")
	val popularity: Double,

	@field:SerializedName("adult")
	val adult: Boolean,

	@field:SerializedName("vote_count")
	val voteCount: Int*/
)
