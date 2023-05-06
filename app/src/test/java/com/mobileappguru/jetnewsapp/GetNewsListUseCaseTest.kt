package com.mobileappguru.jetnewsapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mobileappguru.jetnewsapp.common.Constants
import com.mobileappguru.jetnewsapp.common.Resource
import com.mobileappguru.jetnewsapp.data.model.news.ArticleDto
import com.mobileappguru.jetnewsapp.data.model.news.NewsResponse
import com.mobileappguru.jetnewsapp.data.model.news.Source
import com.mobileappguru.jetnewsapp.domain.repository.NewsRepository
import com.mobileappguru.jetnewsapp.domain.usecase.news.GetNewsListUseCase
import io.mockk.coEvery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import okhttp3.ResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetNewsListUseCaseTest {

    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `test get news list use case success`() = testDispatcher.runBlockingTest {
        // Given
        val newsRepository = mock(NewsRepository::class.java)
        val getNewsListUseCase = GetNewsListUseCase(newsRepository)
        val articles = listOf(
            ArticleDto(
                "Author 1",
                "Content 1",
                "Description 1",
                "2023-05-01T00:00:00Z",
                Source("id1", "source1"),
                "Title 1",
                "url1",
                "urlToImage1"
            )
        )
        val successResponse = Response.success(NewsResponse(articles, "ok", 1))

        coEvery { newsRepository.getNews(any(), any()) } returns successResponse

        // When
        val result = getNewsListUseCase(Constants.API_NEWS_TOKEN, "us").toList()

        // Then
        assert(result.size == 2)
        assert(result[0] is Resource.Loading)
        assert(result[1] is Resource.Success)
        assert((result[1] as Resource.Success).data == articles)
    }

    @Test
    fun `test get news list use case error`() = testDispatcher.runBlockingTest {
        // Given
        val newsRepository = mock(NewsRepository::class.java)
        val getNewsListUseCase = GetNewsListUseCase(newsRepository)
        val errorResponse = Response.error<NewsResponse>(404, ResponseBody.create(null, ""))

        coEvery { newsRepository.getNews(any(), any()) } returns errorResponse

        // When
        val result = getNewsListUseCase(Constants.API_NEWS_TOKEN, "us").toList()

        // Then
        assert(result.size == 2)
        assert(result[0] is Resource.Loading)
        assert(result[1] is Resource.Error)
        assert((result[1] as Resource.Error).message == "Error fetching news")
    }
}