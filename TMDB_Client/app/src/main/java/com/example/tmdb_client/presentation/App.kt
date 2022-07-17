package com.example.tmdb_client.presentation

import android.app.Application
import com.example.tmdb_client.BuildConfig
import com.example.tmdb_client.presentation.di.Injector
import com.example.tmdb_client.presentation.di.core.*
import com.example.tmdb_client.presentation.di.movie.MovieSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

}