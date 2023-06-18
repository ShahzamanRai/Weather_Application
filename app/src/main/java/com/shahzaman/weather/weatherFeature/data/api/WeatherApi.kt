package com.shahzaman.weather.weatherFeature.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/v1/forecast?latitude=30.81&longitude=73.45&hourly=relativehumidity_2m,rain,weathercode,visibility,windspeed_10m&daily=weathercode,temperature_2m_max,temperature_2m_min,rain_sum&timezone=auto")
    suspend fun getWeatherData(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
    ): WeatherDto
}