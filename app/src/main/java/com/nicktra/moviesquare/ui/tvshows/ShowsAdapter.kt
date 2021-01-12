package com.nicktra.moviesquare.ui.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.data.source.remote.response.tvshow.ResultsShowItem
import com.nicktra.moviesquare.databinding.ItemsShowBinding
import com.nicktra.moviesquare.ui.detail.DetailActivity

class ShowsAdapter : RecyclerView.Adapter<ShowsAdapter.ShowViewHolder>() {
    private var listShows = ArrayList<ResultsShowItem>()

    fun setShows(shows: List<ResultsShowItem>?) {
        if (shows.isNullOrEmpty()) return
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
        fun bind(show: ResultsShowItem) {
            with(binding) {
                val year = show.firstAirDate.substring(0,4)
                val titleYear = show.name
                tvItemTitle.text = itemView.context.getString(R.string.item_title, titleYear, year)
                tvItemRating.text = show.voteAverage.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_SHOW, show.id)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/w500" + show.posterPath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(ivItemPoster)
            }
        }
    }
}