package com.nicktra.moviesquare.ui.detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.databinding.ActivityDetailBinding
import com.nicktra.moviesquare.databinding.ContentDetailBinding
import com.nicktra.moviesquare.viewmodel.ViewModelFactory
import com.nicktra.moviesquare.vo.Status
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_SHOW = "extra_show"
        const val TAG = "DetailActivity"
    }

    private lateinit var detailContentBinding: ContentDetailBinding

    private lateinit var viewModel: DetailViewModel
    private var menu: Menu? = null

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
                    viewModel.setSelectedMovie(movieId)
                    viewModel.getDetailMovie.observe(this, { movie ->
                        if (movie != null) {
                            when (movie.status) {
                                Status.LOADING -> showLoading(true)
                                Status.SUCCESS -> {
                                    showLoading(false)
                                    if (movie.data != null) {
                                        populateMovie(movie.data)
                                    }
                                }
                                Status.ERROR -> {
                                    showLoading(false)
                                    Toast.makeText(this, "An Error Occurred", Toast.LENGTH_SHORT)
                                            .show()
                                }
                            }
                        }
                    })
                }

                extras.containsKey(EXTRA_SHOW) -> {
                    viewModel.setSelectedShow(showId)
                    viewModel.getDetailShow.observe(this, { show ->
                        if (show != null) {
                            when (show.status) {
                                Status.LOADING -> showLoading(true)
                                Status.SUCCESS -> {
                                    showLoading(false)
                                    if (show.data != null) {
                                        populateShow(show.data)
                                    }
                                }
                                Status.ERROR -> {
                                    showLoading(false)
                                    Toast.makeText(this, "An Error Occurred", Toast.LENGTH_SHORT)
                                            .show()
                                }
                            }
                        }
                    })
                }
            }
        }

    }

    private fun populateMovie(detailMovieResponse: MovieEntity) {
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

    private fun populateShow(detailShowResponse: ShowEntity) {
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

    private fun showLoading(state: Boolean) {
        if (state) {
            progress_bar.visibility = View.VISIBLE
            content.visibility = View.GONE
        } else {
            progress_bar.visibility = View.GONE
            content.visibility = View.VISIBLE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        val extras = intent.extras

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        if (extras != null) {
            when {
                extras.containsKey(EXTRA_MOVIE) -> {
                    viewModel.getDetailMovie.observe(this, { movie ->
                        if (movie != null) {
                            when (movie.status) {
                                Status.LOADING -> showLoading(true)
                                Status.SUCCESS -> if (movie.data != null) {
                                    showLoading(false)
                                    val state = movie.data.isFavorite
                                    setBookmarkState(state)
                                }
                                Status.ERROR -> {
                                    showLoading(false)
                                    Toast.makeText(applicationContext, "An Error Occurred", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    })
                }
                extras.containsKey(EXTRA_SHOW) -> {
                    viewModel.getDetailShow.observe(this, { show ->
                        if (show != null) {
                            when (show.status) {
                                Status.LOADING -> showLoading(true)
                                Status.SUCCESS -> if (show.data != null) {
                                    showLoading(false)
                                    val state = show.data.isFavorite
                                    setBookmarkState(state)
                                }
                                Status.ERROR -> {
                                    showLoading(false)
                                    Toast.makeText(applicationContext, "An Error Occurred", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    })
                }
            }
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_bookmark) {
            val extras = intent.extras

            val factory = ViewModelFactory.getInstance(this)
            val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

            if (extras != null) {
                when {
                    extras.containsKey(EXTRA_MOVIE) -> {
                        viewModel.setFavoriteMovie()
                    }
                    extras.containsKey(EXTRA_SHOW) -> {
                        viewModel.setFavoriteShow()
                    }
                }
            }

            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setBookmarkState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_bookmark)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmarked_white)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark_white)
        }
    }
}