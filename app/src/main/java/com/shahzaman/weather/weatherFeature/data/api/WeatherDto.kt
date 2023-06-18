package com.shahzaman.weather.weatherFeature.data.api

import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "hourly")
    val weatherHourlyData: HourlyDataDto,

    @field:Json(name = "daily")
    val weatherDailyData: DailyDataDto,

    )