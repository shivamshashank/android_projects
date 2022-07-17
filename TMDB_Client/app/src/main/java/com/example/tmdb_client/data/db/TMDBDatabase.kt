package com.example.tmdb_client.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdb_client.data.db.dao.ArtistsDao
import com.example.tmdb_client.data.db.dao.MoviesDao
import com.example.tmdb_client.data.db.dao.TvShowsDao
import com.example.tmdb_client.data.models.artist.Artist
import com.example.tmdb_client.data.models.movie.Movie
import com.example.tmdb_client.data.models.tv_shows.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false,
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao
    abstract fun tvShowsDao(): TvShowsDao
    abstract fun artistsDao(): ArtistsDao

}