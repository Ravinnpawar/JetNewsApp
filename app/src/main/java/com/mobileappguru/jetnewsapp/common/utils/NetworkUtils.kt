package com.mobileappguru.jetnewsapp.common.utils

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import javax.inject.Inject

class NetworkUtils @Inject constructor(private val connectivityManager: ConnectivityManager) {
    /**
     * Check whether the device is currently connected to the internet.
     *
     * @return true if the device is connected to the internet, false otherwise.
     */
    fun isConnected(): Boolean {
        val network = connectivityManager.activeNetwork ?: return false
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}