package com.example.newsapp.domain.repository

import com.example.newsapp.data.model.news_response_model.Article
import com.example.newsapp.data.model.news_response_model.NewsResponseModel
import com.example.newsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNews(country: String, page: Int): Resource<NewsResponseModel>
    suspend fun getSearchedNews(searchQuery: String): Resource<NewsResponseModel>
    suspend fun saveNews(article: Article)
    suspend fun deleteSavedNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>

}