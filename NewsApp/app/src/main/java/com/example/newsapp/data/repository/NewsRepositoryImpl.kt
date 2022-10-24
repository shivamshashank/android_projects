package com.example.newsapp.data.repository

import com.example.newsapp.data.model.news_response_model.Article
import com.example.newsapp.data.model.news_response_model.NewsResponseModel
import com.example.newsapp.data.repository.data_source.NewsRemoteDataSource
import com.example.newsapp.data.util.Resource
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
) : NewsRepository {

    private fun responseToResource(response: Response<NewsResponseModel>): Resource<NewsResponseModel> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }

        return Resource.Error(response.message())
    }

    override suspend fun getNews(country: String, page: Int): Resource<NewsResponseModel> {
        return responseToResource(newsRemoteDataSource.getNews(country, page))
    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<NewsResponseModel> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSavedNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}