package com.example.data.ui.feature.presintashion.home

import com.example.data.ui.feature.presintashion.home.datasource.CoursesApiService
import com.example.data.ui.feature.presintashion.home.dto.CoursesListDto.Companion.toCoursesList
import com.example.domain.ui.feature.presintashion.home.model.CoursesList
import com.example.domain.ui.feature.presintashion.home.repository.CoursesRepository
import javax.inject.Inject

class CoursesRepositoryImpl @Inject constructor(
    private val apiService: CoursesApiService
) : CoursesRepository {
    override suspend fun getCourses(): CoursesList {
        return apiService.getCourses().toCoursesList()
    }
    override suspend fun searchCourses(query: String): CoursesList {
        val currentCourses = getCourses()
        return if (query.isBlank()) {
            currentCourses
        } else {
            CoursesList(
                courses = currentCourses.courses.filter { course ->
                    course.title.contains(query, ignoreCase = true) ||
                            course.text.contains(query, ignoreCase = true)
                }
            )
        }
    }

}