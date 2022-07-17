package com.example.tmdb_client.data.repository.movie.data_source_impl

import com.example.tmdb_client.data.db.dao.MoviesDao
import com.example.tmdb_client.data.models.movie.Movie
import com.example.tmdb_client.data.repository.movie.data_source.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val moviesDao: MoviesDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> = moviesDao.getMoviesList()

    override suspend fun saveMoviesToDB(moviesList: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            moviesDao.saveMoviesList(moviesList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            moviesDao.deleteMoviesList()
        }
    }
}