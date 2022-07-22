package com.example.tmdb_client.domain.repository

import com.example.tmdb_client.data.models.tv_shows.TvShow

interface TvShowRepository {

    suspend fun getTvShowsList(): List<TvShow>?

}