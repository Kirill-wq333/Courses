package com.example.courses.ui.feature.presintashion.favourite.viewmodel

import com.example.courses.core.viewmodel.ViewEvent

object FavouriteContract {

    sealed interface Event: ViewEvent {
        data object FetchCourses : Event
    }
}