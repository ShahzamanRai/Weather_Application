package com.shahzaman.weather.weatherFeature.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DoubleState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shahzaman.weather.weatherFeature.presentation.WeatherState
import java.time.format.DateTimeFormatter
import java.util.Date

@Composable
fun FilledDate(
    state: WeatherState
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
            ),
            shape = RoundedCornerShape(36.dp)

        ) {
            Text(
                text = data.time.format(DateTimeFormatter.ofPattern("EEEE, d MMMM")),
                color = MaterialTheme.colorScheme.background,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
            )
        }
    }
}
