package com.satyamthakur.newsflash.ui.repository

import com.satyamthakur.newsflash.data.datasource.NewsDataSource
import com.satyamthakur.newsflash.data.entity.NewsResponse
import com.satyamthakur.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {

    suspend fun getNewsHeadline(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getNewsHeadlines(country)
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Something went wrong in fetching news!"))
            }

        }.catch { e ->
            emit(ResourceState.Error("Error: ${e.localizedMessage ?: "Something went wrong in flow"}"))
        }
    }

}