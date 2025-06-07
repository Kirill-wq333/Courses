package com.example.courses.core.module

import com.example.data.ui.feature.presintashion.home.datasource.CoursesApiService
import com.example.data.ui.feature.presintashion.home.datasource.repository.CoursesRepository
import com.example.data.ui.feature.presintashion.home.datasource.repository.CoursesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object CoursesModule {
    @Provides
    fun provideCoursesRepository(api: CoursesApiService) : CoursesRepository {
        return CoursesRepositoryImpl(api)
    }
}