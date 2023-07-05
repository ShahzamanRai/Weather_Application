package com.shahzaman.weather.weatherFeature.data.location

import android.content.ContentValues.TAG
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.util.Log
import java.util.Locale

fun getCityNameFromCoordinates(context: Context, latitude: Double, longitude: Double): String {
    val geocoder = Geocoder(context, Locale.getDefault())
    val addresses: List<Address> = geocoder.getFromLocation(latitude, longitude, 1) as List<Address>
    Log.d(TAG, "getCityNameFromCoordinates: $addresses")

    if (addresses.isNotEmpty()) {
        val address: Address = addresses[0]
        return address.subAdminArea ?: ""
    }

    return ""
}
