package com.example.room1.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.room1.db.SubscriberRepository

class SubscriberViewModelFactory(private val subscriberRepository: SubscriberRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubscriberViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SubscriberViewModel(subscriberRepository) as T
        }

        throw IllegalArgumentException("Unknown View Model Class")
    }
}