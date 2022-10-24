package com.example.newsapp.presentation.news

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.domain.use_cases.GetNewsUseCase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsUseCase: GetNewsUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NewsViewModel(app, getNewsUseCase) as T
        }

        throw IllegalArgumentException("Unknown News View Model Class")
    }

}