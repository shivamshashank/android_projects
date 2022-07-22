package com.example.tmdb_client.data.repository.tv_show.data_source_impl

import com.example.tmdb_client.data.api.TMDBService
import com.example.tmdb_client.data.models.artist.ArtistList
import com.example.tmdb_client.data.models.tv_shows.TvShow
import com.example.tmdb_client.data.models.tv_shows.TvShowsList
import com.example.tmdb_client.data.repository.artist.data_source.ArtistRemoteDataSource
import com.example.tmdb_client.data.repository.tv_show.data_source.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String,
) : TvShowRemoteDataSource {
    override suspend fun getTvShowsList(): Response<TvShowsList> =
        tmdbService.getPopularTvShows(apiKey)
}