package com.satyamthakur.newsflash.di

import com.satyamthakur.newsflash.data.AppConstants.NEWS_BASE_URL
import com.satyamthakur.newsflash.data.api.ApiService
import com.satyamthakur.newsflash.data.datasource.NewsDataSource
import com.satyamthakur.newsflash.data.datasource.NewsDataSourceImpl
import com.satyamthakur.newsflash.ui.repository.NewsRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {

        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

        val httpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
            readTimeout(60, TimeUnit.SECONDS)
        }

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(NEWS_BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    }

    @Singleton
    @Provides
    fun proviedesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesNewsDataSource(apiService: ApiService): NewsDataSource {
        return NewsDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun providesNewsRespository(newsDataSource: NewsDataSource): NewsRepository {
        return NewsRepository(newsDataSource)
    }

}