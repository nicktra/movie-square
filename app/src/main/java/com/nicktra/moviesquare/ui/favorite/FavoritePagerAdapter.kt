package com.nicktra.moviesquare.ui.favorite

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.ui.favorite.favoritemovies.FavoriteMoviesFragment
import com.nicktra.moviesquare.ui.favorite.favoritetvshows.FavoriteShowsFragment

class FavoritePagerAdapter (private val mContext: FavoriteFragment, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tvShow)
    }

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> FavoriteMoviesFragment()
                1 -> FavoriteShowsFragment()
                else -> Fragment()
            }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int {
        return TAB_TITLES.size
    }

}