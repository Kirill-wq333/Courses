package com.example.courses.ui.feature.shared.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.courses.ui.theme.CoursesTypography

@Composable
fun CButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    enable: Boolean = true,
    onClick: () -> Unit
) {
    ButtonContent(
        text = text,
        color = color,
        onClick = onClick,
        enable = enable
    )
}

@Composable
fun ButtonContent(
    text: String,
    color: Color,
    onClick: () -> Unit,
    enable: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                enabled = enable,
                onClick = onClick
            )
            .background(
                color = color,
                shape = RoundedCornerShape(30.dp)
            ),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = text,
            color = Color.White,
            style = CoursesTypography.bodySmall,
            modifier = Modifier.padding(vertical = 10.dp)
        )
    }
}