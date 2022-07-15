package com.example.room1.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SubscriberDAO {
    @Query("SELECT * FROM subscriber_table")
    fun getAllSubscribers(): Flow<List<Subscriber>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSubscriber(subscriber: Subscriber): Long

    @Update
    fun updateSubscriber(subscriber: Subscriber)

    @Delete
    fun deleteSubscriber(subscriber: Subscriber)

    @Query("DELETE FROM subscriber_table")
    fun deleteAllSubscribers()
}