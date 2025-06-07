package com.example.courses.ui.feature.shared.screens.home.componetns

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.courses.R
import com.example.courses.ui.theme.CoursesTypography
import com.example.courses.ui.theme.colors

@Composable
fun DateAdd(
    modifier: Modifier = Modifier
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = stringResource(R.string.date_add),
            color = MaterialTheme.colors.green,
            style = CoursesTypography.bodyMedium
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_down_up),
            tint = Color.Unspecified,
            contentDescription = null
        )
    }
}