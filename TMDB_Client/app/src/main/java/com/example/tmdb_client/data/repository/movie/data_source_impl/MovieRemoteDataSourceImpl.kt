package com.example.tmdb_client.data.repository.movie.data_source_impl

import com.example.tmdb_client.data.api.TMDBService
import com.example.tmdb_client.data.models.movie.MoviesList
import com.example.tmdb_client.data.repository.movie.data_source.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String,
) : MovieRemoteDataSource {
    override suspend fun getMoviesList(): Response<MoviesList> =
        tmdbService.getPopularMovies(apiKey)
}