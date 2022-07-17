package com.example.tmdb_client.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb_client.domain.use_cases.movies.GetMoviesListUseCase
import com.example.tmdb_client.domain.use_cases.movies.UpdateMoviesListUseCase

class MovieViewModelFactory(
    private val getMoviesListUseCase: GetMoviesListUseCase,
    private val updateMoviesListUseCase: UpdateMoviesListUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieViewModel(getMoviesListUseCase, updateMoviesListUseCase) as T
        }

        throw IllegalArgumentException("Unknown Movie View Model Class")
    }
}