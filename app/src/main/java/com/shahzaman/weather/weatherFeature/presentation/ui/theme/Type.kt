package com.shahzaman.weather.weatherFeature.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shahzaman.weather.R


val SFCompact = FontFamily(
    Font(R.font.sf_compact_original),
    Font(R.font.sf_compact_bold, weight = FontWeight.Bold),
    Font(R.font.sf_compact_bold, weight = FontWeight.ExtraBold)
)
val SFCompactModified = FontFamily(
    Font(R.font.sf_compact)
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = SFCompact,
        fontWeight = FontWeight.Bold,
        color = Black,
        fontSize = 28.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displaySmall = TextStyle(
        fontFamily = SFCompact,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = SFCompact,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Black,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = SFCompactModified,
        fontWeight = FontWeight.Normal,
        fontSize = 180.sp,
        color = Black,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = SFCompact,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Black,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
)