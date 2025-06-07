package com.example.data.ui.feature.presintashion.home.datasource.repository

import com.example.data.ui.feature.presintashion.home.datasource.CoursesApiService
import com.example.data.ui.feature.presintashion.home.datasource.dto.CoursesDto.Companion.toCourses
import com.example.data.ui.feature.presintashion.home.datasource.model.Courses
import javax.inject.Inject

class CoursesRepositoryImpl @Inject constructor(
    private val apiService: CoursesApiService
) : CoursesRepository {
    override suspend fun getCourses(): List<Courses> {
        return apiService.getCourses().map { it.toCourses() }
    }
}