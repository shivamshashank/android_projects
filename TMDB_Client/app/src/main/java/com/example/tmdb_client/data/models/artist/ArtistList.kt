package com.example.tmdb_client.data.models.artist


import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("results")
    val results: List<ArtistList>,
)