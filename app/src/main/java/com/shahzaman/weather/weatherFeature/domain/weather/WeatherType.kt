package com.shahzaman.weather.weatherFeature.domain.weather


sealed class WeatherType(
    val weatherDesc: String
) {
    object ClearSky : WeatherType(
        weatherDesc = "Clear sky"
    )

    object MainlyClear : WeatherType(
        weatherDesc = "Mainly clear",
    )

    object PartlyCloudy : WeatherType(
        weatherDesc = "Partly cloudy",
    )

    object Overcast : WeatherType(
        weatherDesc = "Overcast",
    )

    object Foggy : WeatherType(
        weatherDesc = "Foggy",
    )

    object DepositingRimeFog : WeatherType(
        weatherDesc = "Depositing rime fog",
    )

    object LightDrizzle : WeatherType(
        weatherDesc = "Light drizzle",
    )

    object ModerateDrizzle : WeatherType(
        weatherDesc = "Moderate drizzle",
    )

    object DenseDrizzle : WeatherType(
        weatherDesc = "Dense drizzle",
    )

    object LightFreezingDrizzle : WeatherType(
        weatherDesc = "Slight freezing drizzle",
    )

    object DenseFreezingDrizzle : WeatherType(
        weatherDesc = "Dense freezing drizzle",
    )

    object SlightRain : WeatherType(
        weatherDesc = "Slight rain",
    )

    object ModerateRain : WeatherType(
        weatherDesc = "Rainy",
    )

    object HeavyRain : WeatherType(
        weatherDesc = "Heavy rain",
    )

    object HeavyFreezingRain : WeatherType(
        weatherDesc = "Heavy freezing rain",
    )

    object SlightSnowFall : WeatherType(
        weatherDesc = "Slight snow fall",
    )

    object ModerateSnowFall : WeatherType(
        weatherDesc = "Moderate snow fall",
    )

    object HeavySnowFall : WeatherType(
        weatherDesc = "Heavy snow fall",
    )

    object SnowGrains : WeatherType(
        weatherDesc = "Snow grains",
    )

    object SlightRainShowers : WeatherType(
        weatherDesc = "Slight rain showers",
    )

    object ModerateRainShowers : WeatherType(
        weatherDesc = "Moderate rain showers",
    )

    object ViolentRainShowers : WeatherType(
        weatherDesc = "Violent rain showers",
    )

    object SlightSnowShowers : WeatherType(
        weatherDesc = "Light snow showers",
    )

    object HeavySnowShowers : WeatherType(
        weatherDesc = "Heavy snow showers",
    )

    object ModerateThunderstorm : WeatherType(
        weatherDesc = "Moderate thunderstorm",
    )

    object SlightHailThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with slight hail",
    )

    object HeavyHailThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with heavy hail",
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