package com.example.tmdb_client.data.repository.tv_show

import android.util.Log
import com.example.tmdb_client.data.models.tv_shows.TvShow
import com.example.tmdb_client.data.repository.tv_show.data_source.TvShowRemoteDataSource
import com.example.tmdb_client.domain.repository.TvShowRepository

class TvShowRepositoryImpl(private val tvShowRemoteDataSource: TvShowRemoteDataSource) :
    TvShowRepository {

    override suspend fun getTvShowsList(): List<TvShow> {
        return getTvShowsFromAPI()
    }

    private suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShowsList()
            val body = response.body()
            if (body != null) {
                tvShowsList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowsList
    }

}

