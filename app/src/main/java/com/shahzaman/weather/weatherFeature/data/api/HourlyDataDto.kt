package com.shahzaman.weather.weatherFeature.data.api

import com.squareup.moshi.Json

data class HourlyDataDto(
    val time: List<String>,
    val visibility: List<Double>,

    @field:Json(name = "temperature_2m")
    val temperatures: List<Double>,
    @field:Json(name = "weathercode")
    val weatherCodes: List<Int>,
    @field:Json(name = "pressure_msl")
    val pressures: List<Double>,
    @field:Json(name = "windspeed_10m")
    val windSpeeds: List<Double>,
    @field:Json(name = "relativehumidity_2m")
    val humidities: List<Double>
)