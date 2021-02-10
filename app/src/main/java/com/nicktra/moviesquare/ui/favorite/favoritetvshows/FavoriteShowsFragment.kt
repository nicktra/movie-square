package com.nicktra.moviesquare.ui.favorite.favoritetvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.databinding.FragmentFavoriteShowsBinding
import com.nicktra.moviesquare.viewmodel.ViewModelFactory

class FavoriteShowsFragment : Fragment() {
    private var _fragmentFavoriteShowsBinding: FragmentFavoriteShowsBinding? = null
    private val binding get() = _fragmentFavoriteShowsBinding

    private lateinit var viewModel: FavoriteShowsViewModel
    private lateinit var adapter: FavoriteShowsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _fragmentFavoriteShowsBinding = FragmentFavoriteShowsBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFavoriteShow)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteShowsViewModel::class.java]

            adapter = FavoriteShowsAdapter()
            showLoading(true)
            viewModel.getFavoriteShows().observe(viewLifecycleOwner, { shows ->
                showLoading(false)
                adapter.submitList(shows)
            })

            with(binding?.rvFavoriteShow) {
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
                val showEntity = adapter.getSwipedData(swipedPosition)
                showEntity?.let { viewModel.setFavoriteShows(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { _ ->
                    showEntity?.let { viewModel.setFavoriteShows(it) }
                }
                snackbar.show()
            }
        }
    })

    override fun onResume() {
        super.onResume()
        if (view != null) {
            viewModel.getFavoriteShows().observe(viewLifecycleOwner, { shows ->
                adapter.submitList(shows)
            })
        }
    }
}