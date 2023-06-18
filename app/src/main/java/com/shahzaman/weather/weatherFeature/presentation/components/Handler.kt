package com.shahzaman.weather.weatherFeature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shahzaman.weather.weatherFeature.presentation.ui.theme.Black

@Composable
fun TwoLines() {
    Column(
        modifier = Modifier
            .padding(start = 6.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .height(3.dp)
                .width(36.dp)
                .background(Black)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .height(3.dp)
                .width(18.dp)
                .background(Black)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    TwoLines()
}