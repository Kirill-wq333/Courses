package com.example.domain.ui.feature.presintashion.home.repository

import com.example.domain.ui.feature.presintashion.home.model.CoursesList

interface CoursesRepository {
    suspend fun getCourses(): CoursesList
    suspend fun searchCourses(query: String): CoursesList
}