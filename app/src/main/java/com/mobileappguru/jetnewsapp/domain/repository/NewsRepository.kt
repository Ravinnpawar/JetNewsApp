package com.mobileappguru.jetnewsapp.domain.repository

import com.mobileappguru.jetnewsapp.data.model.news.NewsResponse
import retrofit2.Response

interface NewsRepository {

    /**
     * Retrieves the list of news articles for the specified country, using the provided token for authentication.
     *
     * @param token The token to use for authentication.
     * @param country The country for which to retrieve the news articles.
     *
     * @return The response containing the list of news articles, or an error if the request failed.
     */
    suspend fun getNews(token: String, country: String): Response<NewsResponse>

}