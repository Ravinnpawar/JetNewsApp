package com.mobileappguru.jetnewsapp.presentation.navigation

/**
 * Represents the possible screens in the app and their associated navigation routes.
 */
sealed class NavScreen(val route: String) {

    object SplashScreen : NavScreen("splash")
    object NewsListScreen : NavScreen("news")
    object WebPageScreen : NavScreen("web")

}