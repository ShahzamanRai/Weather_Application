package com.shahzaman.weather.weatherFeature.data.repository

import com.shahzaman.weather.weatherFeature.data.api.WeatherApi
import com.shahzaman.weather.weatherFeature.data.mappers.toWeatherInfo
import com.shahzaman.weather.weatherFeature.domain.repository.WeatherRepository
import com.shahzaman.weather.weatherFeature.domain.util.Resource
import com.shahzaman.weather.weatherFeature.domain.util.Resource.Error
import com.shahzaman.weather.weatherFeature.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getweatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    latitude = lat,
                    longitude = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}
