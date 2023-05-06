package com.mobileappguru.jetnewsapp

import com.mobileappguru.jetnewsapp.common.Resource
import com.mobileappguru.jetnewsapp.data.model.news.Source
import com.mobileappguru.jetnewsapp.domain.model.Article
import com.mobileappguru.jetnewsapp.domain.usecase.news.GetNewsListUseCase
import com.mobileappguru.jetnewsapp.presentation.screen.news.NewsListViewModel
import io.mockk.coEvery
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class NewsListViewModelTest {

    private val getNewsListUseCase = mock(GetNewsListUseCase::class.java)
    private val viewModelScope = TestCoroutineScope()
    private lateinit var newsListViewModel: NewsListViewModel

    @Before
    fun setUp() {
        newsListViewModel = NewsListViewModel(getNewsListUseCase)
    }

    @After
    fun tearDown() {
        viewModelScope.cleanupTestCoroutines()
    }

    @Test
    fun `when getNews is called, verify that the news list is updated`() = runBlockingTest {
        // Arrange
        val articles = listOf(Article(
            "John Doe",
            "Lorem Ipsum",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
            "2022-05-06T10:20:30Z",
            Source("CNN", "https://www.cnn.com"),
            "Lorem Ipsum",
            "https://www.cnn.com/article1",
            "https://www.cnn.com/article1/image.jpg"
        ))
        val flow = flow { emit(Resource.Success(articles)) }
        val country = "us"
        coEvery { getNewsListUseCase(any(), country) } returns flow

        // Act
        newsListViewModel.setCountry(country)
        newsListViewModel.getNews()

        // Assert
        assertEquals(Resource.Success(articles), newsListViewModel.news.value)
    }

    @Test
    fun `when setCountry is called, verify that the country is updated`() = runBlockingTest {
        // Arrange
        val country = "gb"

        // Act
        newsListViewModel.setCountry(country)

        // Assert
        assertEquals(country, newsListViewModel.country.value)
    }
}