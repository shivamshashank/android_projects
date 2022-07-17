package com.example.tmdb_client.presentation.di.core

import com.example.tmdb_client.domain.repository.MovieRepository
import com.example.tmdb_client.domain.use_cases.movies.GetMoviesListUseCase
import com.example.tmdb_client.domain.use_cases.movies.UpdateMoviesListUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesListUseCase {
        return GetMoviesListUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesListUseCase {
        return UpdateMoviesListUseCase(movieRepository)
    }

}