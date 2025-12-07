package com.edstry.news.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponseDto(
    @SerialName("articles")
    val articleDtos: List<ArticleDto> = listOf()
)