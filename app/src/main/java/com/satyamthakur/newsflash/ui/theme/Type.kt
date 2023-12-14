package com.satyamthakur.newsflash.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.satyamthakur.newsflash.R

val kanitFont = FontFamily(
    Font(R.font.kanit_light_300, FontWeight.Light),
    Font(R.font.kanit_regular_400, FontWeight.Normal),
    Font(R.font.kanit_medium_500, FontWeight.Medium),
    Font(R.font.kanit_semibold_600, FontWeight.SemiBold),
    Font(R.font.kanit_bold_700, FontWeight.Bold)
)

val titleDisplay = TextStyle (
    fontFamily = kanitFont,
    fontSize = 24.sp,
    fontWeight = FontWeight.SemiBold
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)