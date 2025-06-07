package com.example.data.ui.feature.presintashion.home.datasource.repository

import com.example.data.ui.feature.presintashion.home.datasource.dto.Courses

interface CoursesRepository {
    suspend fun getCourses(url: String): List<Courses>
}