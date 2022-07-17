package com.example.tmdb_client.data.models.movie


import com.google.gson.annotations.SerializedName

data class MoviesList(
    @SerializedName("results")
    val movies: List<Movie>,
)