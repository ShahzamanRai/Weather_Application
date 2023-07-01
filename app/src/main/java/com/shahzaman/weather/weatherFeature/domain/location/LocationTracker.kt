package com.shahzaman.weather.weatherFeature.domain.location

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation() : Location?
}