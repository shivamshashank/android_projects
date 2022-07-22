package com.example.tmdb_client.presentation.di.artist

import com.example.tmdb_client.presentation.artist.ArtistFragment
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistFragment: ArtistFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }

}

