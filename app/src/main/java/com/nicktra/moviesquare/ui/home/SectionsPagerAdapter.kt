package com.nicktra.moviesquare.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.ui.movies.MoviesFragment
import com.nicktra.moviesquare.ui.tvshows.ShowsFragment

class SectionsPagerAdapter(private val mContext: HomeFragment, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tvShow)
    }

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> MoviesFragment()
                1 -> ShowsFragment()
                else -> Fragment()
            }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int {
        return TAB_TITLES.size
    }

}