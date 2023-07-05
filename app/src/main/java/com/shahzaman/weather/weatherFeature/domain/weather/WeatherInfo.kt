package com.shahzaman.weather.weatherFeature.domain.weather

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?,
    val latitude : Double,
    val longitude : Double
)