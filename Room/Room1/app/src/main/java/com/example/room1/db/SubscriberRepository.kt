package com.example.room1.db

import kotlinx.coroutines.flow.Flow

class SubscriberRepository(private val subscriberDAO: SubscriberDAO) {
    val getAllSubscribers: Flow<List<Subscriber>> = subscriberDAO.getAllSubscribers()

    suspend fun insertSubscriber(subscriber: Subscriber) {
        subscriberDAO.insertSubscriber(subscriber)
    }

    suspend fun updateSubscriber(subscriber: Subscriber) {
        subscriberDAO.updateSubscriber(subscriber)
    }

    suspend fun deleteSubscriber(subscriber: Subscriber) {
        subscriberDAO.deleteSubscriber(subscriber)
    }

    suspend fun deleteAllSubscribers() {
        subscriberDAO.deleteAllSubscribers()
    }
}