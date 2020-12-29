package com.nicktra.moviesquare.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
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
import com.nicktra.moviesquare.viewmodel.ViewModelFactory

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

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        val movieId = extras?.getString(EXTRA_MOVIE)
        val showId = extras?.getString(EXTRA_SHOW)

        if (movieId != null) {
            activityDetailBinding.progressBar.visibility = View.VISIBLE
            activityDetailBinding.content.visibility = View.INVISIBLE

            viewModel.setSelectedMovie(movieId)
            viewModel.getMovie().observe(this, { movie ->
                activityDetailBinding.progressBar.visibility = View.GONE
                activityDetailBinding.content.visibility = View.VISIBLE
                populateMovie(movie)
            })
            /*populateMovie(viewModel.getMovie())*/
        } else if (showId != null) {
            activityDetailBinding.progressBar.visibility = View.VISIBLE
            activityDetailBinding.content.visibility = View.INVISIBLE

            viewModel.setSelectedShow(showId)
            viewModel.getShow().observe(this, { show ->
                activityDetailBinding.progressBar.visibility = View.GONE
                activityDetailBinding.content.visibility = View.VISIBLE
                populateShow(show)
            })
            /*populateShow(viewModel.getShow())*/
        }

    }

    private fun populateMovie(movieEntity: MovieEntity) {
        val movieTitle = movieEntity.title
        val movieRelease = movieEntity.release
        val movieRating = movieEntity.rating
        val movieOverview = movieEntity.overview
        val movieImage = movieEntity.image

        detailContentBinding.tvDataTitle.text = movieTitle
        detailContentBinding.tvDataRelease.text = movieRelease
        detailContentBinding.tvDataRating.text = movieRating
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
        val showOverview = showEntity.overview
        val showImage = showEntity.image

        detailContentBinding.tvDataTitle.text = showTitle
        detailContentBinding.tvDataRelease.text = showRelease
        detailContentBinding.tvDataRating.text = showRating
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