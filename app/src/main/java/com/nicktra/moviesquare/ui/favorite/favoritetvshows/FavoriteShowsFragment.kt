package com.nicktra.moviesquare.ui.favorite.favoritetvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicktra.moviesquare.databinding.FragmentFavoriteShowsBinding
import com.nicktra.moviesquare.viewmodel.ViewModelFactory

class FavoriteShowsFragment : Fragment() {
    private var _fragmentFavoriteShowsBinding: FragmentFavoriteShowsBinding? = null
    private val binding get() = _fragmentFavoriteShowsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _fragmentFavoriteShowsBinding = FragmentFavoriteShowsBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteShowsViewModel::class.java]

            val showsAdapter = FavoriteShowsAdapter()
            showLoading(true)
            viewModel.getFavoriteShows().observe(viewLifecycleOwner, { movies ->
                showLoading(false)
                showsAdapter.setShows(movies)
                showsAdapter.notifyDataSetChanged()
            })

            with(binding?.rvFavoriteShow) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = showsAdapter
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