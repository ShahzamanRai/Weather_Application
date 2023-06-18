package com.shahzaman.weather.weatherFeature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shahzaman.weather.R
import com.shahzaman.weather.weatherFeature.presentation.ui.theme.Black

@Composable
fun InfoCard(
    windValue: String, humidityValue: String, visibilityValue: String
) {
    val wind = painterResource(id = R.drawable.wind)
    val humidity = painterResource(id = R.drawable.humidity)
    val visibility = painterResource(id = R.drawable.visibility)
    Card(
        modifier = Modifier.fillMaxWidth(0.82f),
        shape = RoundedCornerShape(16.dp),


        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Black)
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CardComponent(painter = wind, featureName = "Wind", value = windValue)
            CardComponent(painter = humidity, featureName = "Humidity", value = humidityValue)
            CardComponent(painter = visibility, featureName = "Visibility", value = visibilityValue)
        }
    }
}
