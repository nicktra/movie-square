package com.nicktra.moviesquare.ui.tvshows

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.nicktra.moviesquare.databinding.FragmentShowsBinding

class ShowsFragment : Fragment() {

    private lateinit var fragmentShowsBinding: FragmentShowsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentShowsBinding = FragmentShowsBinding.inflate(layoutInflater, container, false)
        return fragmentShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ShowsViewModel::class.java]
            val shows = viewModel.getShows()

            val showsAdapter = ShowsAdapter()
            showsAdapter.setShows(shows)

            with(fragmentShowsBinding.rvShow) {
                val orientation = this@ShowsFragment.resources.configuration.orientation
                val spanCount = if (orientation == Configuration.ORIENTATION_PORTRAIT) 2 else 3

                layoutManager = GridLayoutManager(context, spanCount)
                setHasFixedSize(true)
                adapter = showsAdapter
            }
        }
    }

}