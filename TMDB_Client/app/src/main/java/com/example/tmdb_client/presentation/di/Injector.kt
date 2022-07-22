package com.example.tmdb_client.presentation.di

import com.example.tmdb_client.presentation.di.artist.ArtistSubComponent
import com.example.tmdb_client.presentation.di.movie.MovieSubComponent
import com.example.tmdb_client.presentation.di.tv_show.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvShowsSubComponent(): TvShowSubComponent
}