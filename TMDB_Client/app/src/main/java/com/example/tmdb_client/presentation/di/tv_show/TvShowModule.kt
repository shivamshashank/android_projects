package com.example.tmdb_client.presentation.di.tv_show

import com.example.tmdb_client.domain.use_cases.movies.GetMoviesListUseCase
import com.example.tmdb_client.domain.use_cases.movies.UpdateMoviesListUseCase
import com.example.tmdb_client.domain.use_cases.tv_shows.GetTvShowsListUseCase
import com.example.tmdb_client.presentation.movie.MovieViewModelFactory
import com.example.tmdb_client.presentation.tv_shows.TvShowsViewModel
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsListUseCase: GetTvShowsListUseCase,
    ): TvShowsViewModel {
        return TvShowsViewModel(
            getTvShowsListUseCase
        )
    }

}