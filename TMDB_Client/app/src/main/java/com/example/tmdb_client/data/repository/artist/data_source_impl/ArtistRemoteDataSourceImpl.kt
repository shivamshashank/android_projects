package com.example.tmdb_client.data.repository.artist.data_source_impl

import com.example.tmdb_client.data.api.TMDBService
import com.example.tmdb_client.data.models.artist.ArtistList
import com.example.tmdb_client.data.models.movie.MoviesList
import com.example.tmdb_client.data.repository.artist.data_source.ArtistRemoteDataSource
import com.example.tmdb_client.data.repository.movie.data_source.MovieRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String,
) : ArtistRemoteDataSource {
    override suspend fun getArtistsList(): Response<ArtistList> =
        tmdbService.getPopularArtists(apiKey)
}
