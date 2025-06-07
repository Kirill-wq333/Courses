package com.example.courses.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.courses.R

private val roboto = FontFamily(
    Font(R.font.roboto_regular, FontWeight.W400),
    Font(R.font.roboto_medium, FontWeight.W500),
    Font(R.font.roboto_semibold, FontWeight.W600)
)

@Stable
private fun getLetterSpacing(fontSize: Int): Double =
    if (fontSize >= 16) 0.018 else 0.011

val CoursesTypography: Typography
    @Composable
    get() = Typography(
        titleMedium = TextStyle(
            fontSize = 28.sp,
            lineHeight = 36.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.W400,
            letterSpacing = getLetterSpacing(28).sp
        ),
        titleSmall = TextStyle(
            fontSize = 22.sp,
            lineHeight = 28.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.W400,
            letterSpacing = getLetterSpacing(22).sp
        ),
        bodyLarge = TextStyle(
            fontSize = 16.sp,
            lineHeight = 18.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.W500,
            letterSpacing = getLetterSpacing(16).sp
        ),
        bodyMedium = TextStyle(
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.W500,
            letterSpacing = getLetterSpacing(14).sp
        ),
        bodySmall = TextStyle(
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.W400,
            letterSpacing = getLetterSpacing(14).sp
        ),
        labelLarge = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.W400,
            letterSpacing = getLetterSpacing(12).sp
        ),
        labelMedium = TextStyle(
            fontSize = 12.sp,
            lineHeight = 15.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.W600,
            letterSpacing = getLetterSpacing(12).sp
        ),
        labelSmall = TextStyle(
            fontSize = 12.sp,
            lineHeight = 14.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.W400,
            letterSpacing = getLetterSpacing(12).sp
        )
    )