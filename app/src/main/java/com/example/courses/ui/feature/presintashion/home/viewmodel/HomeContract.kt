package com.example.courses.ui.feature.presintashion.home.viewmodel

import com.example.courses.core.viewmodel.ViewEvent

object HomeContract {

    sealed interface Event: ViewEvent{
        data object FetchCourses : Event
    }

}