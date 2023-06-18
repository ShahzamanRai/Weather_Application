package com.shahzaman.weather.weatherFeature.presentation.screeens

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shahzaman.weather.R
import com.shahzaman.weather.weatherFeature.presentation.components.DailyCard
import com.shahzaman.weather.weatherFeature.presentation.components.FilledDate
import com.shahzaman.weather.weatherFeature.presentation.components.InfoCard
import com.shahzaman.weather.weatherFeature.presentation.components.TwoLines

@Composable
fun MainScreen(
    cityName: String,
    weatherCondition: String,
    temperature: String

) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(cityName = cityName)
        Spacer(modifier = Modifier.height(32.dp))
        FilledDate(text = "Friday, 16 June")
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = weatherCondition,
            style = MaterialTheme.typography.bodyMedium,
        )
        Text(
            text = temperature,
            style = MaterialTheme.typography.titleLarge
        )

        DailySummary()
        Spacer(modifier = Modifier.height(16.dp))
        InfoCard(windValue = "4Km/h", humidityValue = "48%", visibilityValue = "1Km")
        Footer()
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DailyCard(
                date = "11 Aug",
                temperature = "27°",
                icon = painterResource(id = R.drawable.humidity_filled)
            )
            DailyCard(
                date = "12 Aug",
                temperature = "28°",
                icon = painterResource(id = R.drawable.humidity_filled)
            )
            DailyCard(
                date = "13 Aug",
                temperature = "24°",
                icon = painterResource(id = R.drawable.humidity_filled)
            )
            DailyCard(
                date = "14 Aug",
                temperature = "26°",
                icon = painterResource(id = R.drawable.humidity_filled)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MainScreen(
        cityName = "Okara",
        weatherCondition = "Rain",
        temperature = "31°"
    )
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
fun DailySummary() {
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
            text = "Now it feels like +35\", actually +31\".\n" +
                    "It feels hot because of the direct sun. Today,\nthe temperature is felt in the range from +31 to 27.",
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
