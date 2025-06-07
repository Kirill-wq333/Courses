package com.example.data.ui.feature.presintashion.home.datasource

import com.example.data.ui.feature.presintashion.home.datasource.dto.CoursesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CoursesApiService {
    @GET("u/0/uc")
    suspend fun getCourses(
        @Query("id") id: String = "15arTK7XT2b7Yv4BJsmDctA4Hq-BbS8-q",
        @Query("export") export: String = "download"
    ): List<CoursesDto>
}