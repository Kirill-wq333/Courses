package com.example.data.ui.feature.presintashion.home.datasource.dto

import com.example.data.ui.feature.presintashion.home.datasource.model.Courses

data class CoursesDto(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String
){
    companion object{
        fun CoursesDto.toCourses(): Courses =
            Courses(
            id = id,
            title = title,
            text = text,
            price = price,
            rate = rate,
            startDate = startDate,
            hasLike = hasLike,
            publishDate = publishDate,
        )
    }
}