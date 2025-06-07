package com.example.courses.ui.feature.presintashion.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.mock.Mock
import com.example.courses.ui.feature.presintashion.home.viewmodel.HomeContract
import com.example.courses.ui.feature.presintashion.home.viewmodel.HomeViewModel
import com.example.courses.ui.feature.shared.screens.home.componetns.Courses
import com.example.courses.ui.feature.shared.screens.home.componetns.DateAdd
import com.example.data.ui.feature.presintashion.home.datasource.model.Courses

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeContent(
        courses = Mock.demoCourses,
        modifier = Modifier
    )
}


@Composable
fun HomeScreen(
    vm: HomeViewModel
) {

    val courses by vm.courses.collectAsState()

    LaunchedEffect(Unit) {
        vm.handleEvent(HomeContract.Event.FetchCourses)
    }

    Scaffold(
        topBar = {}
    ) {
        HomeContent(
            modifier = Modifier
                .padding(it),
            courses = courses
        )
    }
}

@Composable
private fun HomeContent(
    modifier: Modifier,
    courses: List<Courses>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.End
    ) {
        DateAdd()
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(courses) { item ->
                Courses(
                    hasLike = item.hasLike,
                    rate = item.rate,
                    title = item.title,
                    text = item.text,
                    price = item.price,
                    publishedDate = item.startDate,
                )
            }
        }
    }
}