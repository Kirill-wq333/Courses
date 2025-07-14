package com.example.courses.ui.feature.navigation.bottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.courses.R
import com.example.courses.ui.feature.approuts.AppRouts
import com.example.courses.ui.theme.CoursesTypography
import com.example.courses.ui.theme.colors

data class BottomBarItems(
    val route: String,
    val icon: Int,
    val label: String,
)

@Preview
@Composable
private fun BottomBarPreview() {
    Scaffold(
        containerColor = MaterialTheme.colors.dark,
        bottomBar = {
            BottomBar(rememberNavController())
        }
    ) {
        Box(Modifier.padding(it))
    }
}

@Composable
fun BottomBar(
    navController: NavHostController
) {
    val currentRoute = navController
        .currentBackStackEntryAsState()
        .value
        ?.destination
        ?.route

    val bottomBarItems =listOf(
        BottomBarItems(
            route = AppRouts.HOME,
            label = stringResource(R.string.home_button),
            icon = R.drawable.ic_house
        ),
        BottomBarItems(
            route = AppRouts.FAVOURITE,
            label = stringResource(R.string.favourite_button),
            icon = R.drawable.ic_favourite
        ),
        BottomBarItems(
            route = "",
            label = stringResource(R.string.account_button),
            icon = R.drawable.ic_account
        )
    )

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            HorizontalDivider(modifier = Modifier.fillMaxWidth()
                .background(color = MaterialTheme.colors.stroke))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 8.dp,
                        top = 12.dp,
                        bottom = 16.dp,
                        end = 8.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                bottomBarItems.forEach { item ->
                    val isSelected = currentRoute == item.route

                    val color = if (isSelected) MaterialTheme.colors.green
                    else MaterialTheme.colors.white

                    val boxColor = if (isSelected) MaterialTheme.colors.lightGray
                    else Color.Unspecified

                    BottomBarItem(
                        icon = item.icon,
                        text = item.label,
                        color = color,
                        onClick = { navController.navigate(item.route) },
                        boxColor = boxColor
                    )
                }
            }
        }
    }

}

@Composable
fun BottomBarItem(
    icon: Int,
    text: String,
    onClick: () -> Unit,
    color: Color,
    boxColor: Color
) {

    Column(
        modifier = Modifier
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = boxColor,
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = null,
                tint = color,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            )
        }
        Text(
            text = text,
            color = color,
            style = CoursesTypography.labelMedium
        )
    }
}