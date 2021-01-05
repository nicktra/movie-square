package com.nicktra.moviesquare.ui.detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.data.source.remote.RemoteDataSource
import com.nicktra.moviesquare.data.source.remote.response.movie.DetailMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.DetailShowResponse
import com.nicktra.moviesquare.databinding.ActivityDetailBinding
import com.nicktra.moviesquare.databinding.ContentDetailBinding
import com.nicktra.moviesquare.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_SHOW = "extra_show"
        const val TAG = "DetailActivity"
    }

    private lateinit var detailContentBinding: ContentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailBinding.detailContent

        setContentView(activityDetailBinding.root)

        supportActionBar?.title = getString(R.string.detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras

        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE)
            val showId = extras.getInt(EXTRA_SHOW)
            Log.d(TAG,"movieid: $movieId")

            when {
                extras.containsKey(EXTRA_MOVIE) -> {
                    activityDetailBinding.progressBar.visibility = View.VISIBLE
                    activityDetailBinding.content.visibility = View.INVISIBLE

                    viewModel.setSelectedMovie(movieId)
                    viewModel.getDetailMovie().observe(this, { movie ->
                        activityDetailBinding.progressBar.visibility = View.GONE
                        activityDetailBinding.content.visibility = View.VISIBLE
                        populateMovie(movie)
                    })
                }

                extras.containsKey(EXTRA_SHOW) -> {
                    activityDetailBinding.progressBar.visibility = View.VISIBLE
                    activityDetailBinding.content.visibility = View.INVISIBLE

                    viewModel.setSelectedShow(showId)
                    viewModel.getDetailShow().observe(this, { show ->
                        activityDetailBinding.progressBar.visibility = View.GONE
                        activityDetailBinding.content.visibility = View.VISIBLE
                        populateShow(show)
                    })
                }
            }
        }

    }

    private fun populateMovie(detailMovieResponse: DetailMovieResponse) {
        val movieTitle = detailMovieResponse.title
        val movieRelease = detailMovieResponse.releaseDate
        val movieRating = detailMovieResponse.voteAverage
        val movieOverview = detailMovieResponse.overview
        val movieImage = detailMovieResponse.posterPath

        detailContentBinding.tvDataTitle.text = movieTitle
        detailContentBinding.tvDataRelease.text = movieRelease
        detailContentBinding.tvDataRating.text = movieRating.toString()
        detailContentBinding.tvDataOverview.text = movieOverview

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500$movieImage")
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imageDetail)

        detailContentBinding.btnShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Movie Title: $movieTitle\nRelease Date: $movieRelease\n\nFind more about $movieTitle on Movie Square Apps")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "Share to ")
            startActivity(shareIntent)
        }
    }

    private fun populateShow(detailShowResponse: DetailShowResponse) {
        val showTitle = detailShowResponse.name
        val showRelease = detailShowResponse.firstAirDate
        val showRating = detailShowResponse.voteAverage
        val showOverview = detailShowResponse.overview
        val showImage = detailShowResponse.posterPath

        detailContentBinding.tvDataTitle.text = showTitle
        detailContentBinding.tvDataRelease.text = showRelease
        detailContentBinding.tvDataRating.text = showRating.toString()
        detailContentBinding.tvDataOverview.text = showOverview

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500$showImage")
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imageDetail)

        detailContentBinding.btnShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "TV Show Title: $showTitle\nRelease Date: $showRelease\n\nFind more about $showTitle on Movie Square Apps")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "Share to ")
            startActivity(shareIntent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}