package com.example.tmdb_client.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_client.BuildConfig
import com.example.tmdb_client.R
import com.example.tmdb_client.data.models.movie.Movie
import com.example.tmdb_client.databinding.ListItemBinding

class MovieAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private val moviesList = ArrayList<Movie>()

    fun setMoviesList(movies: List<Movie>) {
        moviesList.clear()
        moviesList.addAll(movies)
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
        holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}

class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.apply {
            binding.nameTextView.text = movie.title
            binding.descriptionTextView.text = movie.overview

            val posterPath: String = BuildConfig.IMAGE_URL + movie.posterPath.toString()

            Glide.with(binding.imageView.context)
                .load(posterPath)
                .into(binding.imageView)
        }
    }

}