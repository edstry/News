package com.edstry.news.data.remote.api


import com.edstry.news.BuildConfig
import com.edstry.news.data.remote.dto.NewsResponseDto
import com.edstry.news.domain.entity.Language
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/everything?apiKey=${BuildConfig.NEWS_API_KEY}")
    suspend fun loadArticles(
        @Query("q") topic: String,
        @Query("language") language: String
    ): NewsResponseDto
}