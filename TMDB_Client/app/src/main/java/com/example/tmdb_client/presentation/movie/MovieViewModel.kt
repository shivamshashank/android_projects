package com.example.tmdb_client.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb_client.domain.use_cases.movies.GetMoviesListUseCase
import com.example.tmdb_client.domain.use_cases.movies.UpdateMoviesListUseCase

class MovieViewModel(
    private val getMoviesListUseCase: GetMoviesListUseCase,
    private val updateMoviesListUseCase: UpdateMoviesListUseCase,
) : ViewModel() {

    fun getMovies() = liveData {
        val moviesList = getMoviesListUseCase.execute()
        emit(moviesList)
    }

    fun updateMovies() = liveData {
        val moviesList = updateMoviesListUseCase.execute()
        emit(moviesList)
    }

}