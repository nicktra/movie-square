package com.nicktra.moviesquare.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.data.MovieEntity
import com.nicktra.moviesquare.data.ShowEntity
import com.nicktra.moviesquare.databinding.ActivityDetailBinding
import com.nicktra.moviesquare.databinding.ContentDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_SHOW = "extra_show"
    }

    private lateinit var detailContentBinding: ContentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailBinding.detailContent

        setContentView(activityDetailBinding.root)

        supportActionBar?.title = getString(R.string.detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        val movieId = extras?.getString(EXTRA_MOVIE)
        val showId = extras?.getString(EXTRA_SHOW)

        if (movieId != null) {
            viewModel.setSelectedMovie(movieId)
            populateMovie(viewModel.getMovie() as MovieEntity)
        } else if (showId != null) {
            viewModel.setSelectedShow(showId)
            populateShow(viewModel.getShow() as ShowEntity)
        }

    }

    private fun populateMovie(movieEntity: MovieEntity) {
        val movieTitle = movieEntity.title
        val movieRelease = movieEntity.release
        val movieRating = movieEntity.rating
        val movieGenre = movieEntity.genre
        val movieOverview = movieEntity.overview
        val movieImage = movieEntity.image

        detailContentBinding.tvDataTitle.text = movieTitle
        detailContentBinding.tvDataRelease.text = movieRelease
        detailContentBinding.tvDataRating.text = movieRating
        detailContentBinding.tvDataGenre.text = movieGenre
        detailContentBinding.tvDataOverview.text = movieOverview

        Glide.with(this)
                .load(movieImage)
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

    private fun populateShow(showEntity: ShowEntity) {
        val showTitle = showEntity.title
        val showRelease = showEntity.release
        val showRating = showEntity.rating
        val showGenre = showEntity.genre
        val showOverview = showEntity.overview
        val showImage = showEntity.image

        detailContentBinding.tvDataTitle.text = showTitle
        detailContentBinding.tvDataRelease.text = showRelease
        detailContentBinding.tvDataRating.text = showRating
        detailContentBinding.tvDataGenre.text = showGenre
        detailContentBinding.tvDataOverview.text = showOverview

        Glide.with(this)
                .load(showImage)
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