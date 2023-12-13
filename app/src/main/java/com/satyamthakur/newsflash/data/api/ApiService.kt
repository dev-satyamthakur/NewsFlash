package com.satyamthakur.newsflash.data.api

import com.satyamthakur.newsflash.BuildConfig
import com.satyamthakur.newsflash.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY
    ) : Response<NewsResponse>

}