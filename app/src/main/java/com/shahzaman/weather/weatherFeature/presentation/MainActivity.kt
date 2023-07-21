package com.shahzaman.weather.weatherFeature.presentation


import android.Manifest
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.shahzaman.weather.weatherFeature.data.location.getCityNameFromCoordinates
import com.shahzaman.weather.weatherFeature.presentation.components.LoadingAnimation
import com.shahzaman.weather.weatherFeature.presentation.screeens.MainScreen
import com.shahzaman.weather.weatherFeature.presentation.ui.theme.BlueColorScheme
import com.shahzaman.weather.weatherFeature.presentation.ui.theme.PinkColorScheme
import com.shahzaman.weather.weatherFeature.presentation.ui.theme.WeatherTheme
import com.shahzaman.weather.weatherFeature.presentation.ui.theme.YellowColorScheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    private var cityName: String = "Weather"
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    companion object {
        var selectedColorScheme: ColorScheme = PinkColorScheme
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val color = getPrimaryColorFromTheme(applicationContext)
        selectedColorScheme = when (color) {
            "Blue" -> BlueColorScheme
            "Pink" -> PinkColorScheme
            "Yellow" -> YellowColorScheme
            else -> BlueColorScheme // Default color in case of any issues
        }
        Log.d(TAG, "onCreate: $color")

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

                val showDialog = remember { mutableStateOf(false) }

                val singleDialogState = remember { mutableStateOf(false) }

                // Conditionally show the dialog based on showDialog state
                if (showDialog.value) {
                    AlertSingleChoiceView(state = singleDialogState,
                        onDismiss = { showDialog.value = false })

                }

                viewModel.state.weatherInfo?.let { data ->
                    cityName = getCityNameFromCoordinates(
                        context = applicationContext,
                        latitude = data.latitude,
                        longitude = data.longitude
                    )
                }

                SwipeRefresh(state = swipeRefreshState,
                    onRefresh = viewModel::loadWeatherInfo,
                    indicator = { state, refreshTrigger ->
                        SwipeRefreshIndicator(
                            state = state,
                            refreshTriggerDistance = refreshTrigger,
                            backgroundColor = MaterialTheme.colorScheme.onBackground,
                            contentColor = MaterialTheme.colorScheme.background,
                        )
                    }) {
                    Box(
                        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.background)
                                .verticalScroll(scrollState)
                        ) {
                            MainScreen(cityName = cityName, state = viewModel.state, onClick = {
                                showDialog.value = true
                            })
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

private fun getPrimaryColorFromTheme(context: Context): String? {
    // Get the saved ARGB color from SharedPreferences
    val sharedPreferences = context.getSharedPreferences("app_theme", Context.MODE_PRIVATE)

    return sharedPreferences.getString("selectedColor", "Blue")
}

@Composable
fun AlertSingleChoiceView(
    state: MutableState<Boolean>, onDismiss: () -> Unit
) {
    val context = LocalContext.current // Get the Context from composition local
    val radioOptions = listOf("Blue", "Pink", "Yellow")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }


    fun setColorScheme(selectedColor: String) {
        // Save the selected color to SharedPreferences
        val sharedPreferences = context.getSharedPreferences("app_theme", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("selectedColor", selectedColor).apply()

        // You can also set the color in your theme or elsewhere in your app as needed
        // For example, if you're using a custom theme with color customization:
        val color = when (selectedColor) {
            "Blue" -> BlueColorScheme
            "Pink" -> PinkColorScheme
            "Yellow" -> YellowColorScheme
            else -> BlueColorScheme // Default color in case of any issues
        }
        MainActivity.selectedColorScheme = color
    }


    AlertDialog(
        onDismissRequest = {
            state.value = false
        },
        title = {
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = "Choose a Color", color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        },
        text = {
            Column(Modifier.selectableGroup()) {
                radioOptions.forEach { text ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = { onOptionSelected(text) },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            onClick = { onOptionSelected(text) })

                        Text(
                            text = text,
                            style = MaterialTheme.typography.displaySmall,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
        },
        dismissButton = {
            Button(onClick = {
                state.value = false
                onDismiss()
            }) {
                Text(
                    "Cancel", style = MaterialTheme.typography.labelLarge
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                setColorScheme(selectedOption)
                state.value = false
                onDismiss()
            }) {
                Text(
                    "Apply", style = MaterialTheme.typography.labelLarge
                )
            }
        },
    )
}
