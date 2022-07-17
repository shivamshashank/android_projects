package com.example.tmdb_client.presentation.di.movie

import com.example.tmdb_client.domain.use_cases.movies.GetMoviesListUseCase
import com.example.tmdb_client.domain.use_cases.movies.UpdateMoviesListUseCase
import com.example.tmdb_client.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesListUseCase: GetMoviesListUseCase,
        updateMoviesListUseCase: UpdateMoviesListUseCase,
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesListUseCase,
            updateMoviesListUseCase,
        )
    }

}