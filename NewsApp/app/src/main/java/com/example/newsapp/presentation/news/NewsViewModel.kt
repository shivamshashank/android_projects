package com.example.newsapp.presentation.news

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.model.news_response_model.NewsResponseModel
import com.example.newsapp.data.util.Resource
import com.example.newsapp.domain.use_cases.GetNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val app: Application,
    private val getNewsUseCase: GetNewsUseCase,
) :
    AndroidViewModel(app) {
    private val news: MutableLiveData<Resource<NewsResponseModel>> = MutableLiveData()

    fun getNews(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        news.postValue(Resource.Loading())

        try {
            if (isNetworkAvailable(app)) {
                val apiResult = getNewsUseCase.execute(country, page)

                news.postValue(apiResult)
            } else {
                news.postValue(Resource.Error("Internet is not available"))
            }
        } catch (e: Exception) {
            news.postValue(Resource.Error(e.message.toString()))
        }
    }

    private fun isNetworkAvailable(context: Context) =
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
            getNetworkCapabilities(activeNetwork)?.run {
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                        || hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                        || hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            } ?: false
        }

}