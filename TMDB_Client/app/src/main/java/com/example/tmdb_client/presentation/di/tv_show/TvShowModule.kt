package com.example.tmdb_client.presentation.di.tv_show

import com.example.tmdb_client.domain.use_cases.tv_shows.GetTvShowsListUseCase
import com.example.tmdb_client.presentation.tv_shows.TvShowsViewModel
import com.example.tmdb_client.presentation.tv_shows.TvShowsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsListUseCase: GetTvShowsListUseCase,
    ): TvShowsViewModelFactory {
        return TvShowsViewModelFactory(
            getTvShowsListUseCase
        )
    }

}