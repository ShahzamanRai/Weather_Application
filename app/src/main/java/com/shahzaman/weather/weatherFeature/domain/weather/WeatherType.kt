package com.shahzaman.weather.weatherFeature.domain.weather

import androidx.annotation.DrawableRes
import com.shahzaman.weather.R


sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int
) {
    object ClearSky : WeatherType(
        weatherDesc = "Clear sky",
        iconRes = R.drawable.sunny_48px
    )

    object MainlyClear : WeatherType(
        weatherDesc = "Mainly clear",
        iconRes = R.drawable.baseline_wb_cloudy_24
    )

    object PartlyCloudy : WeatherType(
        weatherDesc = "Partly cloudy",
        iconRes = R.drawable.baseline_wb_cloudy_24
    )

    object Overcast : WeatherType(
        weatherDesc = "Overcast",
        iconRes = R.drawable.baseline_wb_cloudy_24
    )

    object Foggy : WeatherType(
        weatherDesc = "Foggy",
        iconRes = R.drawable.baseline_wb_cloudy_24
    )

    object DepositingRimeFog : WeatherType(
        weatherDesc = "Depositing rime fog",
        iconRes = R.drawable.baseline_wb_cloudy_24
    )

    object LightDrizzle : WeatherType(
        weatherDesc = "Light drizzle",
        iconRes = R.drawable.humidity_filled
    )

    object ModerateDrizzle : WeatherType(
        weatherDesc = "Moderate drizzle",
        iconRes = R.drawable.humidity_filled
    )

    object DenseDrizzle : WeatherType(
        weatherDesc = "Dense drizzle",
        iconRes = R.drawable.humidity_filled
    )

    object LightFreezingDrizzle : WeatherType(
        weatherDesc = "Slight freezing drizzle",
        iconRes = R.drawable.weather_snowy_48px
    )

    object DenseFreezingDrizzle : WeatherType(
        weatherDesc = "Dense freezing drizzle",
        iconRes = R.drawable.weather_snowy_48px
    )

    object SlightRain : WeatherType(
        weatherDesc = "Slight rain",
        iconRes = R.drawable.humidity_filled
    )

    object ModerateRain : WeatherType(
        weatherDesc = "Rainy",
        iconRes = R.drawable.humidity_filled
    )

    object HeavyRain : WeatherType(
        weatherDesc = "Heavy rain",
        iconRes = R.drawable.humidity_filled
    )

    object HeavyFreezingRain : WeatherType(
        weatherDesc = "Heavy freezing rain",
        iconRes = R.drawable.weather_snowy_48px
    )

    object SlightSnowFall : WeatherType(
        weatherDesc = "Slight snow fall",
        iconRes = R.drawable.weather_snowy_48px
    )

    object ModerateSnowFall : WeatherType(
        weatherDesc = "Moderate snow fall",
        iconRes = R.drawable.snowing_48px
    )

    object HeavySnowFall : WeatherType(
        weatherDesc = "Heavy snow fall",
        iconRes = R.drawable.snowing_48px
    )

    object SnowGrains : WeatherType(
        weatherDesc = "Snow grains",
        iconRes = R.drawable.snowing_48px
    )

    object SlightRainShowers : WeatherType(
        weatherDesc = "Slight rain showers",
        iconRes = R.drawable.humidity_filled
    )

    object ModerateRainShowers : WeatherType(
        weatherDesc = "Moderate rain showers",
        iconRes = R.drawable.humidity_filled
    )

    object ViolentRainShowers : WeatherType(
        weatherDesc = "Violent rain showers",
        iconRes = R.drawable.humidity_filled
    )

    object SlightSnowShowers : WeatherType(
        weatherDesc = "Light snow showers",
        iconRes = R.drawable.weather_snowy_48px
    )

    object HeavySnowShowers : WeatherType(
        weatherDesc = "Heavy snow showers",
        iconRes = R.drawable.weather_snowy_48px
    )

    object ModerateThunderstorm : WeatherType(
        weatherDesc = "Moderate thunderstorm",
        iconRes = R.drawable.baseline_electric_bolt_24
    )

    object SlightHailThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with slight hail",
        iconRes = R.drawable.baseline_electric_bolt_24
    )

    object HeavyHailThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with heavy hail",
        iconRes = R.drawable.baseline_electric_bolt_24
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}