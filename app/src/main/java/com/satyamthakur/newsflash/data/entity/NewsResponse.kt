package com.satyamthakur.newsflash.data.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsResponse(
    @Json(name = "articles")
    val articles: List<Article?>? = null,
    @Json(name = "status")
    val status: String? = null,
    @Json(name = "totalResults")
    val totalResults: Int? = null
) {
    @JsonClass(generateAdapter = true)
    data class Article(
        @Json(name = "author")
        val author: String? = null,
        @Json(name = "content")
        val content: String? = null,
        @Json(name = "description")
        val description: String? = null,
        @Json(name = "publishedAt")
        val publishedAt: String? = null,
        @Json(name = "source")
        val source: Source? = null,
        @Json(name = "title")
        val title: String? = null,
        @Json(name = "url")
        val url: String? = null,
        @Json(name = "urlToImage")
        val urlToImage: String? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class Source(
            @Json(name = "id")
            val id: String? = null,
            @Json(name = "name")
            val name: String? = null
        )
    }
}