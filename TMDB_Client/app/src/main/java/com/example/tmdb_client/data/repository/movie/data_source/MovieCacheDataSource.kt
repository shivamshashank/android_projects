package com.example.tmdb_client.data.repository.movie.data_source

import com.example.tmdb_client.data.models.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesListFromCache(): List<Movie>
    suspend fun saveMoviesListToCache(moviesList: List<Movie>)
}