package com.example.tmdb_client.presentation.di

import com.example.tmdb_client.presentation.di.movie.MovieSubComponent

interface Injector {
   fun createMovieSubComponent(): MovieSubComponent
}