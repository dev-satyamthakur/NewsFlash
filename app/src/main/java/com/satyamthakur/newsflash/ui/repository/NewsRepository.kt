package com.satyamthakur.newsflash.ui.repository

import com.satyamthakur.newsflash.data.datasource.NewsDataSource
import com.satyamthakur.newsflash.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {

    suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return  newsDataSource.getNewsHeadlines(country)
    }

}