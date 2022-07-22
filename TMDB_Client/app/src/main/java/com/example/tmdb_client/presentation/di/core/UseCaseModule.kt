package com.example.tmdb_client.presentation.di.core

import com.example.tmdb_client.domain.repository.ArtistRepository
import com.example.tmdb_client.domain.repository.MovieRepository
import com.example.tmdb_client.domain.repository.TvShowRepository
import com.example.tmdb_client.domain.use_cases.artists.GetArtistsListUseCase
import com.example.tmdb_client.domain.use_cases.movies.GetMoviesListUseCase
import com.example.tmdb_client.domain.use_cases.movies.UpdateMoviesListUseCase
import com.example.tmdb_client.domain.use_cases.tv_shows.GetTvShowsListUseCase
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

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsListUseCase {
        return GetArtistsListUseCase(artistRepository)
    }

    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository: TvShowRepository): GetTvShowsListUseCase {
        return GetTvShowsListUseCase(tvShowRepository)
    }

}