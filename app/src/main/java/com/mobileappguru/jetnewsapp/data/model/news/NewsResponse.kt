package com.mobileappguru.jetnewsapp.data.model.news

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsResponse(
    @Json(name = "articles")
    val articles: List<ArticleDto>?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "totalResults")
    val totalResults: Int?
)

