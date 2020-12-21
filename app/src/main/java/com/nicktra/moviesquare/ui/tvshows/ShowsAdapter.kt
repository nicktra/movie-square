package com.nicktra.moviesquare.ui.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.data.MovieEntity
import com.nicktra.moviesquare.data.ShowEntity
import com.nicktra.moviesquare.databinding.ItemsMovieBinding
import com.nicktra.moviesquare.databinding.ItemsShowBinding
import com.nicktra.moviesquare.ui.detail.DetailActivity
import com.nicktra.moviesquare.ui.movies.MoviesAdapter

class ShowsAdapter : RecyclerView.Adapter<ShowsAdapter.ShowViewHolder>() {
    private var listShows = ArrayList<ShowEntity>()

    fun setShows(shows: List<ShowEntity>?) {
        if (shows == null) return
        this.listShows.clear()
        this.listShows.addAll(shows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val itemsShowBinding = ItemsShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowViewHolder(itemsShowBinding)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val show = listShows[position]
        holder.bind(show)
    }

    override fun getItemCount(): Int = listShows.size


    class ShowViewHolder(private val binding: ItemsShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: ShowEntity) {
            with(binding) {
                tvItemTitle.text = show.title
                tvItemRelease.text = show.release
                tvItemRating.text = show.rating
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_SHOW, show.showId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load(show.image)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgPoster)
            }
        }
    }
}