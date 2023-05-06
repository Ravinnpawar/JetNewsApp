package com.mobileappguru.jetnewsapp.presentation.navigation

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mobileappguru.jetnewsapp.common.Constants
import com.mobileappguru.jetnewsapp.presentation.screen.news.NewsListScreen
import com.mobileappguru.jetnewsapp.presentation.screen.splash.SplashScreen
import com.mobileappguru.jetnewsapp.presentation.screen.web.WebPageScreen

@Composable
fun NavGraph() {
    // Create a NavController to handle navigation within the app
    val navController = rememberNavController()
    // Create a ComposeNavigator that implements the Navigator interface
    val navigator: Navigator = NavigatorImpl(navController)

    // Define the screens that can be navigated to
    NavHost(
        navController = navController,
        startDestination = NavScreen.SplashScreen.route
    ) {
        // Define the SplashScreen screen
        composable(NavScreen.SplashScreen.route) {
            SplashScreen(navigator)
        }
        // Define the NewsListScreen screen
        composable(NavScreen.NewsListScreen.route) {
            NewsListScreen(navigator)
        }

        // Déclarer la destination avec des arguments dans NavGraph

        composable(route = NavScreen.WebPageScreen.route) { backStackEntry ->
            //val newsUrl: String = backStackEntry.arguments?.getParcelable<StringParcelable>(WEB_URL_KEY)?.value ?: ""
            val newsUrl = navController.previousBackStackEntry?.savedStateHandle?.get<String>(
                Constants.WEB_URL_KEY)

            Log.d(ContentValues.TAG, "NavGraph: ${newsUrl}")

            if (newsUrl != null) {
                WebPageScreen(navigator = navigator, navController = navController, urlToRender = newsUrl)
            }
        }
    }
}
