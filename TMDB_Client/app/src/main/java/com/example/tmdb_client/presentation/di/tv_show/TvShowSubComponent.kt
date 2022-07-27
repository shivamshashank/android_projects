package com.example.tmdb_client.presentation.di.tv_show

import com.example.tmdb_client.presentation.tv_shows.TvShowsFragment
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowsFragment: TvShowsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }

}

