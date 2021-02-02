package com.nicktra.moviesquare.ui.favorite.favoritetvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.databinding.ItemsFavoriteShowBinding
import com.nicktra.moviesquare.databinding.ItemsShowBinding
import com.nicktra.moviesquare.ui.detail.DetailActivity

class FavoriteShowsAdapter : PagedListAdapter<ShowEntity, FavoriteShowsAdapter.FavoriteShowViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ShowEntity>() {
            override fun areItemsTheSame(oldItem: ShowEntity, newItem: ShowEntity): Boolean {
                return oldItem.showId == newItem.showId
            }

            override fun areContentsTheSame(oldItem: ShowEntity, newItem: ShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteShowViewHolder {
        val itemsFavoriteShowBinding = ItemsFavoriteShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteShowViewHolder(itemsFavoriteShowBinding)
    }

    override fun onBindViewHolder(holder: FavoriteShowViewHolder, position: Int) {
        val show = getItem(position)
        if (show != null) {
            holder.bind(show)
        }
    }

    fun getSwipedData(swipedPosition: Int): ShowEntity? = getItem(swipedPosition)

    inner class FavoriteShowViewHolder(private val binding: ItemsFavoriteShowBinding) : RecyclerView.ViewHolder(binding.root) {
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