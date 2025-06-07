package com.example.courses.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.courses.ui.feature.navigation.NavigationBuilder
import com.example.courses.ui.feature.navigation.bottomBar.BottomBar

@Composable
fun NavigationHost(
    navController: NavHostController?
) {
    if (navController == null) return
    var visibleBottomBar by remember { mutableStateOf(false) }

    HostScaffold(
        bottomBar = {
            if (visibleBottomBar) {
                BottomBar(
                    navController = navController
                )
            }
        }
    ) {paddingValues ->
        NavigationBuilder(
            navController = navController,
            paddingValues = paddingValues,
            visibleBottomBar = { visible -> visibleBottomBar = visible },
        )
    }
}

@Composable
private fun HostScaffold(
    bottomBar: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = bottomBar,
        content = content,
    )

}