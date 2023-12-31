package com.shahzaman.weather.weatherFeature.data.mappers

import com.shahzaman.weather.weatherFeature.data.api.HourlyDataDto
import com.shahzaman.weather.weatherFeature.data.api.WeatherDto
import com.shahzaman.weather.weatherFeature.domain.weather.WeatherData
import com.shahzaman.weather.weatherFeature.domain.weather.WeatherInfo
import com.shahzaman.weather.weatherFeature.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


private data class IndexedWeatherData(
    val index: Int, val data: WeatherData
)

fun HourlyDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        IndexedWeatherData(
            index = index, data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherHourlyData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else if (now.hour == 23) 12.00 else now.hour + 1
        it.time.hour == hour
    }
    val latitude = latitude
    val longitude = longitude

    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData,
        latitude,
        longitude
    )
}