package com.nicktra.moviesquare.data.source.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class DiscoverShowResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<ResultsShowItem>,

	@field:SerializedName("total_results")
	val totalResults: Int
)

data class ResultsShowItem(
		@field:SerializedName("id")
		val id: Int,

		@field:SerializedName("name")
		val name: String,

		@field:SerializedName("overview")
		val overview: String,

		@field:SerializedName("poster_path")
		val posterPath: String,

		@field:SerializedName("first_air_date")
		val firstAirDate: String,

		@field:SerializedName("vote_average")
		val voteAverage: Double,

		@field:SerializedName("popularity")
		val popularity: Double,

	/*@field:SerializedName("original_language")
	val originalLanguage: String,

	@field:SerializedName("genre_ids")
	val genreIds: List<Int>,

	@field:SerializedName("origin_country")
	val originCountry: List<String>,

	@field:SerializedName("backdrop_path")
	val backdropPath: String,

	@field:SerializedName("original_name")
	val originalName: String,

	@field:SerializedName("vote_count")
	val voteCount: Int*/
)
