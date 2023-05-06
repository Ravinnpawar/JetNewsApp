package com.mobileappguru.jetnewsapp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mobileappguru.jetnewsapp.common.Resource
import com.mobileappguru.jetnewsapp.domain.model.Article
import com.mobileappguru.jetnewsapp.presentation.navigation.NavScreen
import com.mobileappguru.jetnewsapp.presentation.navigation.Navigator
import com.mobileappguru.jetnewsapp.presentation.screen.news.NewsListScreen
import com.mobileappguru.jetnewsapp.presentation.screen.news.NewsListViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import io.mockk.every
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalMaterial3Api
@RunWith(AndroidJUnit4::class)
class NewsListScreenTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    /*   @Test
        fun testNewsListScreen() {
        val viewModel = mock<NewsListViewModel>()
        val navigator = mock<Navigator>()
        val uiState = Resource.Success(listOf(Article("title", "description", "url")))
        every { viewModel.news } returns flowOf(uiState)

        composeTestRule.setContent {
            NewsListScreen(navigator = navigator, viewModel = viewModel)
        }

        // Assert that the title of the screen is displayed
        composeTestRule.onNodeWithText("News", useUnmergedTree = true).assertIsDisplayed()

        // Assert that the article list is displayed
        composeTestRule.onNodeWithTag(ArticleListTag, useUnmergedTree = true).assertIsDisplayed()

        // Assert that the news card is displayed
        composeTestRule.onNodeWithText("title", useUnmergedTree = true).assertIsDisplayed()
    }*/
}