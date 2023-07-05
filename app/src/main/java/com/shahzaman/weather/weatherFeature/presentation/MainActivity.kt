package com.shahzaman.weather.weatherFeature.presentation


import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.shahzaman.weather.weatherFeature.data.location.getCityNameFromCoordinates
import com.shahzaman.weather.weatherFeature.presentation.components.LoadingAnimation
import com.shahzaman.weather.weatherFeature.presentation.screeens.MainScreen
import com.shahzaman.weather.weatherFeature.presentation.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    private var cityName: String = "Weather"
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

                val isLoading by viewModel.isLoading.collectAsState()
                val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isLoading)
                val scrollState = rememberScrollState()

                viewModel.state.weatherInfo?.let { data ->
                    cityName =
                        getCityNameFromCoordinates(
                            context = applicationContext,
                            latitude = data.latitude,
                            longitude = data.longitude
                        )
                }

                SwipeRefresh(
                    state = swipeRefreshState,
                    onRefresh = viewModel::loadWeatherInfo,
                    indicator = { state, refreshTrigger ->
                        SwipeRefreshIndicator(
                            state = state,
                            refreshTriggerDistance = refreshTrigger,
                            backgroundColor = MaterialTheme.colorScheme.onBackground,
                            contentColor = MaterialTheme.colorScheme.background,
                        )
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.background)
                                .verticalScroll(scrollState)
                        ) {
                            MainScreen(cityName = cityName, state = viewModel.state)
                        }
                        if (viewModel.state.isLoading) {
                            LoadingAnimation(
                                modifier = Modifier,
                            )
                        }
                        viewModel.state.error?.let { error ->
                            Text(
                                text = error,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.align(Alignment.Center),
                                fontStyle = MaterialTheme.typography.bodyLarge.fontStyle
                            )
                        }

                    }
                }
            }
        }
    }
}
