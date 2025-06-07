package com.example.courses.ui.feature.presintashion.home.viewmodel

import com.example.courses.core.viewmodel.ViewEffect
import com.example.courses.core.viewmodel.ViewEvent
import com.example.courses.core.viewmodel.ViewState
import com.example.data.ui.feature.presintashion.home.datasource.model.Courses

object HomeContract {

    sealed interface Event: ViewEvent{
        data object FetchCourses : Event
        data object ResetError : Event
    }

}