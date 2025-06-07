package com.example.data.ui.feature.presintashion.home.datasource

import com.example.data.ui.feature.presintashion.home.datasource.dto.CoursesResponse
import retrofit2.http.Url
import retrofit2.http.GET

interface CoursesApiService {
    @GET
    suspend fun getCourses(@Url url: String): CoursesResponse
}