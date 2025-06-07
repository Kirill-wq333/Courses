package com.example.data.ui.feature.presintashion.home.datasource.dto

data class Courses(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String
)

data class CoursesResponse(
    val courses: List<Courses>
)