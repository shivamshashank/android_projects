package com.example.tmdb_client.data.models.tv_shows


import com.google.gson.annotations.SerializedName

data class TvShowsList(
    @SerializedName("results")
    val tvShows: List<TvShow>,
)