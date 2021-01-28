package com.nicktra.moviesquare.ui.favorite.favoritemovies

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.nicktra.moviesquare.databinding.FragmentFavoriteMoviesBinding
import com.nicktra.moviesquare.viewmodel.ViewModelFactory

class FavoriteMoviesFragment : Fragment() {
    private var _fragmentFavoriteMoviesBinding: FragmentFavoriteMoviesBinding? = null
    private val binding get() = _fragmentFavoriteMoviesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _fragmentFavoriteMoviesBinding = FragmentFavoriteMoviesBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteMoviesViewModel::class.java]

            val moviesAdapter = FavoriteMoviesAdapter()
            showLoading(true)
            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, { movies ->
                showLoading(false)
                moviesAdapter.setMovies(movies)
                moviesAdapter.notifyDataSetChanged()
            })

            with(binding?.rvFavoriteMovie) {
                val orientation = this@FavoriteMoviesFragment.resources.configuration.orientation
                val spanCount = if (orientation == Configuration.ORIENTATION_PORTRAIT) 2 else 3

                this?.layoutManager = GridLayoutManager(context, spanCount)
                this?.setHasFixedSize(true)
                this?.adapter = moviesAdapter
            }
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding?.progressBar?.visibility = View.VISIBLE
        } else {
            binding?.progressBar?.visibility = View.GONE
        }
    }
}