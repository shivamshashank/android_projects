package com.example.tmdb_client.domain.repository

import com.example.tmdb_client.data.models.artist.Artist

interface ArtistRepository {

    suspend fun getArtistsList(): List<Artist>?
    suspend fun updateArtistsList(): List<Artist>?

}