package com.mobileappguru.jetnewsapp.domain.model

import com.mobileappguru.jetnewsapp.data.model.news.Source


data class Article(
    var author: String?,
    var content: String?,
    var description: String?,
    var publishedAt: String?,
    var source: Source?,
    var title: String?,
    var url: String?,
    var urlToImage: String?
)
