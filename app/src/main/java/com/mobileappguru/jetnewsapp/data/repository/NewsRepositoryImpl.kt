package com.mobileappguru.jetnewsapp.data.repository

import com.mobileappguru.jetnewsapp.data.model.news.NewsResponse
import com.mobileappguru.jetnewsapp.data.remote.NewsApi
import com.mobileappguru.jetnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
): NewsRepository {

    /**
     * This function retrieves the top headlines news from the NewsAPI endpoint
     * for a given country and authorization token.
     * @param token Authorization token to access the NewsAPI endpoint
     * @param country Country code for which to retrieve the news
     * @return A Retrofit response object containing the news response from the endpoint
     */
    override suspend fun getNews(token: String, country: String): Response<NewsResponse> {
        return withContext(Dispatchers.IO) {
            newsApi.getTopHeadlines(token, country)
        }
    }

}