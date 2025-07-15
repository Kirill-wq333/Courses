package com.example.courses.ui.feature.presintashion.onboarding.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.R
import com.example.courses.ui.feature.shared.button.CButton
import com.example.courses.ui.theme.CoursesTypography
import com.example.courses.ui.theme.colors

data class CourseItemData(
    val text: String,
    val color: Color,
    val rotate: Float = 0f
)

@Preview
@Composable
private fun Pr() {
    OnboardingScreen(openRegisterScreen = {})
}

@Composable
fun OnboardingScreen(
    openRegisterScreen: () -> Unit
) {
    OnboardingContent(
        openRegisterScreen = openRegisterScreen
    )
}

@Composable
fun OnboardingContent(
    openRegisterScreen: () -> Unit
) {
    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                CButton(
                    text = stringResource(R.string.next_screen),
                    onClick = openRegisterScreen,
                    modifier = Modifier
                        .padding(
                            horizontal = 16.dp,
                            vertical = 32.dp
                        )
                )
            }
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Content()
        }

    }
}

@Composable
private fun Content() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Text(
            text = stringResource(R.string.one_hundred_courses),
            color = MaterialTheme.colors.white,
            style = CoursesTypography.titleMedium,
            textAlign = TextAlign.Center
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CoursesThree()
            Spacer(modifier = Modifier.height(8.dp))
            CoursesFour()
        }
    }
}

@Composable
private fun CoursesThree() {
    val listState = rememberLazyGridState()

    val courses = remember {
        listOf(
            CourseItemData("1С Администрирование", Color(0xFF32333A)),
            CourseItemData("RabbitMQ", Color(0xFF12B956), -15f),
            CourseItemData("Трафик", Color(0xFF32333A)),
            CourseItemData("Контент маркетинг", Color(0xFF32333A)),
            CourseItemData("B2B маркетинг", Color(0xFF32333A)),
            CourseItemData("Google Аналитика", Color(0xFF32333A)),
            CourseItemData("UX исследователь", Color(0xFF32333A)),
            CourseItemData("Веб-аналитика", Color(0xFF32333A)),
            CourseItemData("Big Data", Color(0xFF12B956), 15f),
        )
    }
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .fillMaxWidth()
    ) {
        LazyVerticalGrid(
            state = listState,
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .width(650.dp)
                .height(200.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(courses) { i ->
                CourseItem(
                    text = i.text,
                    color = i.color,
                    rotate = i.rotate
                )
            }
        }
    }
}

@Composable
fun CoursesFour() {
    val listState = rememberLazyGridState()

    val courses = remember {
        listOf(
            CourseItemData("Геймдизайн", Color(0xFF32333A)),
            CourseItemData("Веб-дизайн", Color(0xFF32333A)),
            CourseItemData("Cinema 4D", Color(0xFF32333A)),
            CourseItemData("Промпт инженеринг", Color(0xFF32333A)),
            CourseItemData("Webflow", Color(0xFF32333A)),
            CourseItemData("Three", Color(0xFF12B956), -15f),
            CourseItemData("Парсинг", Color(0xFF32333A)),
            CourseItemData("Python-разработка", Color(0xFF32333A)),
        )
    }
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LazyVerticalGrid(
            state = listState,
            columns = GridCells.Fixed(4),
            modifier = Modifier
                .fillMaxWidth()
                .width(550.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(courses) { i ->
                CourseItem(
                    text = i.text,
                    color = i.color,
                    rotate = i.rotate
                )
            }
        }
    }
}


@Composable
private fun CourseItem(
    text: String,
    color: Color,
    rotate: Float
) {
    Box(
        modifier = Modifier
            .rotate(rotate)
            .background(
                color = color,
                shape = RoundedCornerShape(100.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = MaterialTheme.colors.white,
            style = CoursesTypography.bodyMedium,
            modifier = Modifier
                .padding(
                    horizontal = 24.dp,
                    vertical = 20.dp
                )
        )
    }
}