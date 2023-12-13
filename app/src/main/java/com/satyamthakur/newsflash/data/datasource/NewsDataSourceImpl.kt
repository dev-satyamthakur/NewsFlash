package com.satyamthakur.newsflash.data.datasource

import com.satyamthakur.newsflash.data.api.ApiService
import com.satyamthakur.newsflash.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource {


    override suspend fun getNewsHeadlines(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadlines(country)
    }

}