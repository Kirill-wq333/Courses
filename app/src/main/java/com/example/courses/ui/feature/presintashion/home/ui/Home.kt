package com.example.courses.ui.feature.presintashion.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.R
import com.example.courses.mock.Mock
import com.example.courses.ui.feature.presintashion.home.viewmodel.HomeContract
import com.example.courses.ui.feature.presintashion.home.viewmodel.HomeViewModel
import com.example.courses.ui.feature.shared.screens.home.componetns.Courses
import com.example.courses.ui.feature.shared.screens.home.componetns.DateAdd
import com.example.courses.ui.feature.shared.text.textfield.CustomSearchBar
import com.example.courses.ui.theme.colors
import com.example.data.ui.feature.presintashion.home.datasource.model.Courses
import com.example.data.ui.feature.presintashion.home.datasource.model.CoursesList
import retrofit2.http.Query

//@Preview
//@Composable
//private fun HomeScreenPreview() {
//    HomeContent(
//        courses = Mock.demoCourses,
//        modifier = Modifier
//    )
//}


@Composable
fun HomeScreen(
    vm: HomeViewModel
) {

    val courses by vm.courses.collectAsState()

    var query by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        vm.handleEvent(HomeContract.Event.FetchCourses)
    }

    Scaffold(
        topBar = {
            TopBar(
                query = query,
                onQueryChange = { query = it }
            )
        }
    ) {
        HomeContent(
            modifier = Modifier
                .padding(it),
            courses = courses
        )
    }
}

@Composable
fun TopBar(
    query: String,
    onQueryChange: (String) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        CustomSearchBar(
            modifier = Modifier
                .weight(0.7f),
            query = query,
            onQueryChange = onQueryChange,
            onSearch = {}
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colors.darkGray,
                    shape = RoundedCornerShape(28.dp)
                )
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_filter),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}

@Composable
private fun HomeContent(
    modifier: Modifier,
    courses: CoursesList
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
            items(courses.courses) { item ->
                Courses(
                    courses = item
                )
            }
        }
    }
}