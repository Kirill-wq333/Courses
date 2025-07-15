package com.example.courses.ui.feature.presintashion.favourite.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.courses.R
import com.example.courses.ui.feature.presintashion.favourite.viewmodel.FavouriteContract
import com.example.courses.ui.feature.presintashion.favourite.viewmodel.FavouriteViewModel
import com.example.courses.ui.feature.shared.screens.home.componetns.Courses
import com.example.courses.ui.theme.CoursesTypography
import com.example.courses.ui.theme.colors
import com.example.domain.ui.feature.presintashion.home.model.CoursesList

@Composable
fun FavouriteScreen(
    vm: FavouriteViewModel
) {
    val courses by vm.courses.collectAsState()
    val isLoading by vm.isLoading

    LaunchedEffect(Unit) {
        vm.handleEvent(FavouriteContract.Event.FetchCourses)
    }
        FavouriteContent(
            courses = courses,
            isLoading = isLoading
        )
}

@Composable
fun FavouriteContent(
    courses: CoursesList,
    isLoading: Boolean
) {
    val likedCourses = courses.courses.filter { it.hasLike }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.favourite),
            color = MaterialTheme.colors.white,
            style = CoursesTypography.titleSmall
        )
        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            if (isLoading) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(likedCourses) { item ->
                        Courses(courses = item)
                    }
                }
            }
        }
    }
}