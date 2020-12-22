package com.nicktra.moviesquare.ui.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = showsAdapter
            }
        }
    }

}