package com.shahzaman.weather.weatherFeature.presentation

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.shahzaman.weather.weatherFeature.presentation.ui.theme.WeatherTheme
import com.shahzaman.weather.weatherFeature.presentation.screeens.MainScreen
import com.shahzaman.weather.weatherFeature.presentation.ui.theme.Black
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
            )
        )
        setContent {
            WeatherTheme {

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),

                    ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {


                        MainScreen(
                            cityName = "Okara",
                            state = viewModel.state
                        )

                        if (viewModel.state.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                        viewModel.state.error?.let { error ->
                            Text(
                                text = error,
                                color = Black,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }

                    }
                }
            }
        }
    }
}

