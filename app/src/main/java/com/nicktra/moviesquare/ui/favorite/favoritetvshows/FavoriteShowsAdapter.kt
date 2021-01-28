package com.nicktra.moviesquare.ui.favorite.favoritetvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.databinding.ItemsShowBinding
import com.nicktra.moviesquare.ui.detail.DetailActivity

class FavoriteShowsAdapter : RecyclerView.Adapter<FavoriteShowsAdapter.FavoriteShowViewHolder>() {
    private var listShows = ArrayList<ShowEntity>()

    fun setShows(shows: List<ShowEntity>?) {
        if (shows.isNullOrEmpty()) return
        this.listShows.clear()
        this.listShows.addAll(shows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteShowViewHolder {
        val itemsShowBinding = ItemsShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteShowViewHolder(itemsShowBinding)
    }

    override fun onBindViewHolder(holder: FavoriteShowViewHolder, position: Int) {
        val show = listShows[position]
        holder.bind(show)
    }

    override fun getItemCount(): Int = listShows.size


    class FavoriteShowViewHolder(private val binding: ItemsShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: ShowEntity) {
            with(binding) {
                val year = show.firstAirDate.substring(0,4)
                val titleYear = show.name
                tvItemTitle.text = itemView.context.getString(R.string.item_title, titleYear, year)
                tvItemRating.text = show.voteAverage.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_SHOW, show.showId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500" + show.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(ivItemPoster)
            }
        }
    }
}