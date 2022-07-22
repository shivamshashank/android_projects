package com.example.tmdb_client.data.repository.artist

import android.util.Log
import com.example.tmdb_client.data.models.artist.Artist
import com.example.tmdb_client.data.repository.artist.data_source.ArtistRemoteDataSource
import com.example.tmdb_client.domain.repository.ArtistRepository

class ArtistRepositoryImpl(private val artistRemoteDataSource: ArtistRemoteDataSource) : ArtistRepository {

    override suspend fun getArtistsList(): List<Artist> {
        return  getArtistFromAPI()
    }

    private suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtistsList()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

}