package com.wreker.collegemajorproject.model

data class GetTopNewsHeadlines(
    val articles: List<Article> = emptyList(),
    val status: String = "",
    val totalResults: Int = 0
)