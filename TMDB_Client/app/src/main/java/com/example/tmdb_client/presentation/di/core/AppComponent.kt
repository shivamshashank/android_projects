package com.example.tmdb_client.presentation.di.core

import com.example.tmdb_client.presentation.di.artist.ArtistSubComponent
import com.example.tmdb_client.presentation.di.movie.MovieSubComponent
import com.example.tmdb_client.presentation.di.tv_show.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory

}