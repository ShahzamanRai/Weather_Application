package com.shahzaman.weather.weatherFeature.domain.repository

import com.shahzaman.weather.weatherFeature.domain.util.Resource
import com.shahzaman.weather.weatherFeature.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getweatherData(lat: Double, long: Double): Resource<WeatherInfo>
}