package com.example.room1.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room1.db.Subscriber
import com.example.room1.db.SubscriberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubscriberViewModel(private val subscriberRepository: SubscriberRepository) : ViewModel() {
    val getAllSubscribers = subscriberRepository.getAllSubscribers

    fun insertSubscriber(subscriber: Subscriber) =
        viewModelScope.launch(Dispatchers.IO) {
            subscriberRepository.insertSubscriber(subscriber)
        }

    fun updateSubscriber(subscriber: Subscriber) =
        viewModelScope.launch(Dispatchers.IO) {
            subscriberRepository.updateSubscriber(subscriber)
        }

    fun deleteSubscriber(subscriber: Subscriber) =
        viewModelScope.launch(Dispatchers.IO) {
            subscriberRepository.deleteSubscriber(subscriber)
        }

    fun deleteAllSubscribers() =
        viewModelScope.launch(Dispatchers.IO) {
            subscriberRepository.deleteAllSubscribers()
        }
}