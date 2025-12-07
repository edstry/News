package com.edstry.news.data.remote.api


import com.edstry.news.data.remote.dto.NewsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/everything?apiKey=e979569e25a8470996112cc3bb9b9a38")
    suspend fun loadArticles(
        @Query("q") topic: String
    ): NewsResponseDto
}