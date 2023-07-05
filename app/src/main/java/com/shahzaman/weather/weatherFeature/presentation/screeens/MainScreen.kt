package com.shahzaman.weather.weatherFeature.presentation.screeens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shahzaman.weather.R
import com.shahzaman.weather.weatherFeature.domain.weather.WeatherType
import com.shahzaman.weather.weatherFeature.presentation.WeatherState
import com.shahzaman.weather.weatherFeature.presentation.components.DailyCard
import com.shahzaman.weather.weatherFeature.presentation.components.FilledDate
import com.shahzaman.weather.weatherFeature.presentation.components.InfoCard
import com.shahzaman.weather.weatherFeature.presentation.components.TwoLines
import java.time.format.DateTimeFormatter

@Composable
fun MainScreen(
    cityName: String,
    state: WeatherState
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header(cityName = cityName)
            Spacer(modifier = Modifier.height(32.dp))
            FilledDate(
                state = state
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = data.weatherType.weatherDesc,
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                text = "${data.temperatureCelsius.toInt()}°",
                style = MaterialTheme.typography.titleLarge
            )

            DailySummary(
                temperature = data.temperatureCelsius,
                weatherType = data.weatherType
            )
            Spacer(modifier = Modifier.height(16.dp))
            InfoCard(
                windValue = "${data.windSpeed}Km/h",
                humidityValue = "${data.humidity.toInt()}%",
                visibilityValue = "${data.pressure.toInt()}Km"
            )
            Footer()
            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(state = state)
        }
    }
}


@Composable
fun Header(
    cityName: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TwoLines()
        Text(
            text = cityName,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "",
            modifier = Modifier.width(36.dp)
        )
    }
}

@Composable
fun DailySummary(
    temperature: Double,
    weatherType: WeatherType
) {
    Column {

        Text(
            text = "Daily Summary",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(horizontal = 16.dp),
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Now it feels like ${temperature.toInt()}\", actually +$temperature\".\n" +
                    "It seems like ${weatherType.weatherDesc}. Today,\nthe temperature is felt in the range from +31 to 27.",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 16.dp),
            fontSize = 12.sp
        )
    }
}

@Composable
fun Footer(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Weekly forecast",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp
        )
        Image(
            painter = painterResource(id = R.drawable.arrow_indicator),
            contentDescription = "",
            modifier = Modifier
                .size(36.dp),
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyRow(
    state: WeatherState
) {
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                items(data) { weatherData ->
                    DailyCard(
                        date = weatherData.time.format(DateTimeFormatter.ofPattern("HH:mm")),
                        temperature = "${weatherData.temperatureCelsius.toInt().toString()}°",
                        icon = painterResource(id = R.drawable.humidity_filled),
                        modifier = Modifier
                    )
                }
            })
    }
}
