package com.satyamthakur.newsflash.data.datasource

import com.satyamthakur.newsflash.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {

    suspend fun getNewsHeadlines(country: String): Response<NewsResponse>

}