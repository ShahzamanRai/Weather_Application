package com.shahzaman.weather.weatherFeature.data.api

data class DailyDataDto(
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>,
)