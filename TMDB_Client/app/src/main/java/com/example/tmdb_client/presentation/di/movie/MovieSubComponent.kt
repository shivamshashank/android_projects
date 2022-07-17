package com.example.tmdb_client.presentation.di.movie

import com.example.tmdb_client.presentation.movie.MovieFragment
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieFragment: MovieFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }

}

