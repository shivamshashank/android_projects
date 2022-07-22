package com.example.tmdb_client.presentation.tv_shows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_client.BuildConfig
import com.example.tmdb_client.R
import com.example.tmdb_client.data.models.tv_shows.TvShow
import com.example.tmdb_client.databinding.ListItemBinding

class TvShowAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowsList = ArrayList<TvShow>()

    fun setTvShowsList(movies: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemBinding>(
            layoutInflater,
            R.layout.list_item,
            parent,
            false,
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowsList[position])
    }

    override fun getItemCount(): Int {
        return tvShowsList.size
    }
}

class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShow: TvShow) {
        binding.apply {
            binding.nameTextView.text = tvShow.name + " - " + tvShow.firstAirDate
            binding.descriptionTextView.text = tvShow.overview

            val posterPath: String = BuildConfig.IMAGE_URL + tvShow.overview.toString()

            Glide.with(binding.imageView.context)
                .load(posterPath)
                .into(binding.imageView)
        }
    }

}