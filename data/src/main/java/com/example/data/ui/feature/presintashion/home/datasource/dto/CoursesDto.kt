package com.example.data.ui.feature.presintashion.home.datasource.dto

import com.example.data.ui.feature.presintashion.home.datasource.dto.CoursesDto.Companion.toCourses
import com.example.data.ui.feature.presintashion.home.datasource.model.Courses
import com.example.data.ui.feature.presintashion.home.datasource.model.CoursesList

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

data class CoursesListDto(
    val courses: List<CoursesDto>
){
    companion object{
        fun CoursesListDto.toCoursesList(): CoursesList =
            CoursesList(
                courses = courses.map { it.toCourses() }
            )
    }
}