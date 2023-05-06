package com.mobileappguru.jetnewsapp.presentation.navigation.arguments

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// It's a Parcelable data class used to send data to the next screen.

@Parcelize
data class StringParcelable(val value: String) : Parcelable