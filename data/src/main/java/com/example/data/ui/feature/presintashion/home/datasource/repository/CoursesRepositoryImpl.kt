package com.example.data.ui.feature.presintashion.home.datasource.repository

import com.example.data.ui.feature.presintashion.home.datasource.CoursesApiService
import com.example.data.ui.feature.presintashion.home.datasource.dto.Courses
import javax.inject.Inject

class CoursesRepositoryImpl @Inject constructor(
    private val apiService: CoursesApiService
) : CoursesRepository {
    override suspend fun getCourses(url: String): List<Courses> {
        return apiService.getCourses(url).courses
    }
}