package com.example.tmdb_client.presentation.di.tv_show

import com.example.tmdb_client.presentation.di.movie.MovieModule
import com.example.tmdb_client.presentation.di.movie.MovieScope
import com.example.tmdb_client.presentation.movie.MovieFragment
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowModule: TvShowModule)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }

}

