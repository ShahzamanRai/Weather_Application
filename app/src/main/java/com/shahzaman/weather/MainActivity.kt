package com.shahzaman.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shahzaman.weather.ui.theme.Black
import com.shahzaman.weather.ui.theme.Blue
import com.shahzaman.weather.ui.theme.WeatherTheme
import com.shahzaman.weather.weatherFeature.ui.DailyCard
import com.shahzaman.weather.weatherFeature.ui.TwoLines

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val imagePainter = painterResource(id = R.drawable.humidity)

            WeatherTheme {
                /*
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Blue),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = imagePainter, contentDescription ="", modifier = Modifier.size(56.dp))
                    Spacer(modifier = Modifier.height(25.dp))
                    Image(painter = image2Painter, contentDescription ="", modifier = Modifier.size(56.dp))
                    Spacer(modifier = Modifier.height(25.dp))
                    Image(painter = image3Painter, contentDescription ="", modifier = Modifier.size(36.dp))
                    Spacer(modifier = Modifier.height(25.dp))
                    TwoLines()
                    Text(
                        text = "31°",
                        color = Black,
                        style = MaterialTheme.typography.titleLarge
                    )


                }
                 */

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Blue)
                        .padding(bottom = 40.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    DailyCard(
                        date = "11 Aug",
                        temperature = "27°",
                        icon = painterResource(id = R.drawable.humidity)
                    )
                    DailyCard(
                        date = "12 Aug",
                        temperature = "28°",
                        icon = painterResource(id = R.drawable.humidity)
                    )
                    DailyCard(
                        date = "13 Aug",
                        temperature = "24°",
                        icon = painterResource(id = R.drawable.humidity)
                    )
                    DailyCard(
                        date = "14 Aug",
                        temperature = "26°",
                        icon = painterResource(id = R.drawable.humidity)
                    )
                }


            }
        }
    }
}

