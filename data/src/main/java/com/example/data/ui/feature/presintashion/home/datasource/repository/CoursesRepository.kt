package com.example.data.ui.feature.presintashion.home.datasource.repository

import com.example.data.ui.feature.presintashion.home.datasource.model.Courses

interface CoursesRepository {
    suspend fun getCourses(): List<Courses>
}