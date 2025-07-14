package com.example.data.ui.feature.presintashion.home.datasource

import com.example.data.ui.feature.presintashion.home.dto.CoursesListDto
import retrofit2.http.GET
import retrofit2.http.Url

interface CoursesApiService {
    @GET
    suspend fun getCourses(
        @Url url: String = "https://drive.usercontent.google.com/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download"
    ): CoursesListDto
}