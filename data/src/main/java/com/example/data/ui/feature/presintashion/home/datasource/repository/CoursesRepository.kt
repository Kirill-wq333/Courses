package com.example.data.ui.feature.presintashion.home.datasource.repository

import com.example.data.ui.feature.presintashion.home.datasource.CoursesApiService
import com.example.data.ui.feature.presintashion.home.datasource.model.Courses
import javax.inject.Inject

interface CoursesRepository {
    suspend fun getCourses(): List<Courses>
}