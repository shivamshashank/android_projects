package com.example.tmdb_client.data.repository.artist.data_source

import com.example.tmdb_client.data.models.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtistsList() : Response<ArtistList>
}