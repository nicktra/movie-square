package com.nicktra.moviesquare.ui.favorite.favoritemovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.databinding.FragmentFavoriteMoviesBinding
import com.nicktra.moviesquare.viewmodel.ViewModelFactory

class FavoriteMoviesFragment : Fragment() {
    private var _fragmentFavoriteMoviesBinding: FragmentFavoriteMoviesBinding? = null
    private val binding get() = _fragmentFavoriteMoviesBinding

    private lateinit var viewModel: FavoriteMoviesViewModel
    private lateinit var adapter: FavoriteMoviesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _fragmentFavoriteMoviesBinding = FragmentFavoriteMoviesBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFavoriteMovie)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteMoviesViewModel::class.java]

            adapter = FavoriteMoviesAdapter()
            showLoading(true)
            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, { movies ->
                showLoading(false)
                if (movies.isEmpty()) {
                    binding?.tvNoFavorite?.isVisible  = true
                    binding?.ivItemFavorite?.isVisible  = true
                    binding?.rvFavoriteMovie?.isVisible = false
                }
                else {
                    binding?.tvNoFavorite?.isVisible = false
                    binding?.ivItemFavorite?.isVisible  = false
                    binding?.rvFavoriteMovie?.isVisible = true
                }
                adapter.submitList(movies)
            })

            with(binding?.rvFavoriteMovie) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = adapter
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

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
                makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val movieEntity = adapter.getSwipedData(swipedPosition)
                movieEntity?.let { viewModel.setFavoriteMovies(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { _ ->
                    movieEntity?.let { viewModel.setFavoriteMovies(it) }
                }
                snackbar.show()
            }
        }
    })

    override fun onResume() {
        super.onResume()
        if (view != null) {
            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, { movies ->
                adapter.submitList(movies)
            })
        }
    }
}