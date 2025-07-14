package com.example.data.ui.core.module

import com.example.data.ui.feature.presintashion.home.CoursesRepositoryImpl
import com.example.domain.ui.feature.presintashion.home.repository.CoursesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCoursesRepository(
        impl: CoursesRepositoryImpl
    ): CoursesRepository

}