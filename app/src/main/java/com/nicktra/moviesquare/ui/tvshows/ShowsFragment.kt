package com.nicktra.moviesquare.ui.tvshows

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.nicktra.moviesquare.databinding.FragmentShowsBinding
import com.nicktra.moviesquare.viewmodel.ViewModelFactory

class ShowsFragment : Fragment() {

    private lateinit var fragmentShowsBinding: FragmentShowsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        fragmentShowsBinding = FragmentShowsBinding.inflate(layoutInflater, container, false)
        return fragmentShowsBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[ShowsViewModel::class.java]

            val showsAdapter = ShowsAdapter()

            showLoading(true)
            viewModel.getAllShows().observe(viewLifecycleOwner, { shows ->
                showLoading(false)
                showsAdapter.setShows(shows)
                showsAdapter.notifyDataSetChanged()
            })

            with(fragmentShowsBinding.rvShow) {
                val orientation = this@ShowsFragment.resources.configuration.orientation
                val spanCount = if (orientation == Configuration.ORIENTATION_PORTRAIT) 2 else 3

                layoutManager = GridLayoutManager(context, spanCount)
                setHasFixedSize(true)
                adapter = showsAdapter
            }
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            fragmentShowsBinding.progressBar.visibility = View.VISIBLE
        } else {
            fragmentShowsBinding.progressBar.visibility = View.GONE
        }
    }

}