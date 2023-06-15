package com.shahzaman.weather.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shahzaman.weather.R


val Ledger = FontFamily(
        Font(R.font.ledger)
)
val SFCompact = FontFamily(
        Font(R.font.sf_compact)
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = SFCompact,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = SFCompact,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = SFCompact,
        fontWeight = FontWeight.Normal,
        fontSize = 180.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
)