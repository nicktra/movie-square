package com.nicktra.moviesquare.ui.tvshows

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.nicktra.moviesquare.databinding.FragmentShowsBinding
import com.nicktra.moviesquare.viewmodel.ViewModelFactory
import com.nicktra.moviesquare.vo.Status

class ShowsFragment : Fragment() {

    private var _fragmentShowsBinding: FragmentShowsBinding? = null
    private val binding get() = _fragmentShowsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _fragmentShowsBinding = FragmentShowsBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[ShowsViewModel::class.java]

            val showsAdapter = ShowsAdapter()
            viewModel.getAllShows().observe(viewLifecycleOwner, { shows ->
                if (shows != null) {
                    when (shows.status) {
                        Status.LOADING -> showLoading(true)
                        Status.SUCCESS -> {
                            showLoading(false)
                            showsAdapter.submitList(shows.data)
                        }
                        Status.ERROR -> {
                            showLoading(false)
                            Toast.makeText(context, "An Error Occurred", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding?.rvShow) {
                val orientation = this@ShowsFragment.resources.configuration.orientation
                val spanCount = if (orientation == Configuration.ORIENTATION_PORTRAIT) 2 else 3

                this?.layoutManager = GridLayoutManager(context, spanCount)
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