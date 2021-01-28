package com.nicktra.moviesquare.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicktra.moviesquare.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            //Setup ViewPager
            val sectionsPagerAdapter =
                SectionsPagerAdapter(this, childFragmentManager)
            view_pager.adapter = sectionsPagerAdapter
            tabs.setupWithViewPager(view_pager)
        }
    }

}