package com.example.data.ui.feature.presintashion.home.datasource.repository

import com.example.data.ui.feature.presintashion.home.datasource.model.Courses
import com.example.data.ui.feature.presintashion.home.datasource.model.CoursesList

interface CoursesRepository {
    suspend fun getCourses(): CoursesList
}