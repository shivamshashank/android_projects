package com.example.tmdb_client.domain.use_cases.movies

import com.example.tmdb_client.data.models.movie.Movie
import com.example.tmdb_client.domain.repository.MovieRepository

class GetMoviesListUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMoviesList()

}