package com.example.tmdb_client.data.repository.movie.data_source_impl

import com.example.tmdb_client.data.models.movie.Movie
import com.example.tmdb_client.data.repository.movie.data_source.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movies = ArrayList<Movie>()

    override suspend fun getMoviesListFromCache(): List<Movie> {
        return movies
    }

    override suspend fun saveMoviesListToCache(moviesList: List<Movie>) {
        movies.clear()
        movies = ArrayList(moviesList)
    }
}