package com.example.courses.ui.feature.shared.screens.home.componetns

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.courses.R
import com.example.courses.ui.theme.CoursesTypography
import com.example.courses.ui.theme.colors
import com.example.domain.ui.feature.presintashion.home.model.Courses
import com.example.domain.ui.feature.presintashion.home.model.CoursesList

@Composable
fun Courses(
    courses: Courses,
) {
    var hasLikeState by rememberSaveable { mutableStateOf(courses.hasLike) }

    Course(
        hasLike = hasLikeState,
        rate = courses.rate,
        title = courses.title,
        text = courses.text,
        price = courses.price,
        publishedDate = courses.publishDate,
        onFavouriteClick = { hasLikeState = !hasLikeState }
    )
}

@Composable
fun Course(
    hasLike: Boolean,
    rate: String,
    title: String,
    text: String,
    price: String,
    onFavouriteClick: () -> Unit,
    publishedDate: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colors.darkGray,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        CoursesContent(
            hasLike = hasLike,
            rate = rate,
            publishedDate = publishedDate,
            title = title,
            text = text,
            price = price,
            onFavouriteClick = onFavouriteClick
        )
    }
}

@Composable
fun CoursesContent(
    hasLike: Boolean,
    rate: String,
    publishedDate: String,
    title: String,
    text: String,
    onFavouriteClick: () -> Unit,
    price: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            hasLike = hasLike,
            rate = rate,
            publishedDate = publishedDate,
            onFavouriteClick = onFavouriteClick
        )
        BottomContentCourses(
            title = title,
            text = text,
            price = price
        )
    }
}

@Composable
fun BottomContentCourses(
    title: String,
    text: String,
    price: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                bottom = 16.dp,
                end = 16.dp
            ),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            color = MaterialTheme.colors.white,
            style = CoursesTypography.bodyLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = text.limit(100),
            color = MaterialTheme.colors.white,
            style = CoursesTypography.labelLarge,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$price ₽",
                color = MaterialTheme.colors.white,
                style = CoursesTypography.bodyLarge
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.more_detailed),
                    color = MaterialTheme.colors.green,
                    style = CoursesTypography.bodyMedium
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_right),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }
    }
}

fun String.limit(maxLength: Int): String {
    return if (this.length > maxLength) {
        this.take(maxLength) + "..."
    } else {
        this
    }
}

@Composable
fun Image(
    hasLike: Boolean,
    rate: String,
    onFavouriteClick: () -> Unit,
    publishedDate: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(114.dp)
            .background(
                color = MaterialTheme.colors.white,
                shape = RoundedCornerShape(12.dp)
            )
    ){
        FavouriteButton(
            hasLike = hasLike,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp),
            onFavouriteClick = onFavouriteClick
        )
        RateAndDate(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp),
            publishedDate = publishedDate,
            rate = rate
        )
    }
}

@Composable
fun RateAndDate(
    modifier: Modifier = Modifier,
    publishedDate: String,
    rate: String
) {
    Box(modifier = modifier) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
                Box(
                    modifier = Modifier
                        .size(46.dp, 22.dp)
                        .blur(
                            radius = 16.dp,
                            edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(16.dp))
                        )
                        .graphicsLayer {
                            shape = RoundedCornerShape(16.dp)
                            clip = true
                        }
                        .background(
                            color = MaterialTheme.colors.glass.copy(0.3f),
                        )


                )


            Box(
                modifier = Modifier
                    .size(87.dp, 22.dp)
                    .blur(
                        radius = 16.dp,
                        edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(16.dp))
                    )
                    .graphicsLayer {
                        shape = RoundedCornerShape(16.dp)
                        clip = true
                    }
                    .background(
                        color = MaterialTheme.colors.glass.copy(0.3f),
                    )
            )
        }
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Row(
                modifier = Modifier
                    .padding(
                        horizontal = 6.dp,
                        vertical = 4.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_star_fill),
                    contentDescription = null,
                    tint = MaterialTheme.colors.green
                )
                Text(
                    text = rate,
                    color = MaterialTheme.colors.white,
                    style = CoursesTypography.labelSmall
                )
            }


            Text(
                text = publishedDate,
                color = MaterialTheme.colors.white,
                style = CoursesTypography.labelSmall,
            )
        }
    }

}

@Composable
fun FavouriteButton(
    hasLike: Boolean,
    modifier: Modifier,
    onFavouriteClick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colors.glass.copy(0.3f),
                shape = RoundedCornerShape(20.dp)
            )
            .clickable {  onFavouriteClick() },
        contentAlignment = Alignment.Center
    ){
        Icon(
            imageVector = ImageVector.vectorResource(if (hasLike)R.drawable.ic_green_favourite else R.drawable.ic_favourite),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .padding(6.dp)
        )
    }
}