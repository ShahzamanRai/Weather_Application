package com.shahzaman.weather.weatherFeature.presentation

import com.shahzaman.weather.weatherFeature.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)