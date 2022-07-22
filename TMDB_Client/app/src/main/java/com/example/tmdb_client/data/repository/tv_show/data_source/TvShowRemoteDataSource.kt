package com.example.tmdb_client.data.repository.tv_show.data_source

import com.example.tmdb_client.data.models.artist.ArtistList
import com.example.tmdb_client.data.models.tv_shows.TvShow
import com.example.tmdb_client.data.models.tv_shows.TvShowsList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShowsList() : Response<TvShowsList>
}

