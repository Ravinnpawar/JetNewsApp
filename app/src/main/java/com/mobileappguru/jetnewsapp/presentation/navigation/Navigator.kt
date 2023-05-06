package com.mobileappguru.jetnewsapp.presentation.navigation

/**
 * Navigator interface used for navigating between different screens.
 */
interface Navigator {

    fun navigateToSplash()

    fun navigateToNewsList()

    fun navigateToWebPage(newsUrlParcelable: String)
}