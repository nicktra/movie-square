package com.nicktra.moviesquare.ui.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.databinding.FragmentMoviesBinding
import com.nicktra.moviesquare.databinding.FragmentShowsBinding
import com.nicktra.moviesquare.ui.movies.MoviesAdapter
import com.nicktra.moviesquare.ui.movies.MoviesViewModel
import com.nicktra.moviesquare.utils.DataDummy

/**
 * A simple [Fragment] subclass.
 * Use the [ShowsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowsFragment : Fragment() {
    // TODO: Rename and change types of parameters
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