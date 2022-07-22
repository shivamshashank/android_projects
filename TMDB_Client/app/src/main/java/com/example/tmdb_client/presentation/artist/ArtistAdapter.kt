package com.example.tmdb_client.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_client.BuildConfig
import com.example.tmdb_client.R
import com.example.tmdb_client.data.models.artist.Artist
import com.example.tmdb_client.databinding.ListItemBinding

class ArtistAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val artistsList = ArrayList<Artist>()

    fun setArtistsList(artists: List<Artist>) {
        artistsList.clear()
        artistsList.addAll(artists)
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
        holder.bind(artistsList[position])
    }

    override fun getItemCount(): Int {
        return artistsList.size
    }
}

class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(artist: Artist) {
        binding.apply {
            binding.nameTextView.text = artist.name
            binding.descriptionTextView.text = artist.id.toString() + " - " + artist.popularity

            val posterPath: String = BuildConfig.IMAGE_URL + artist.profilePath.toString()

            Glide.with(binding.imageView.context)
                .load(posterPath)
                .into(binding.imageView)
        }
    }

}