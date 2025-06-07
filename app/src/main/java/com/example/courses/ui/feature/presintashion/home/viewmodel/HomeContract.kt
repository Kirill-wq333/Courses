package com.example.courses.ui.feature.presintashion.home.viewmodel

import com.example.courses.core.viewmodel.ViewEffect
import com.example.courses.core.viewmodel.ViewEvent
import com.example.courses.core.viewmodel.ViewState

object HomeContract {
    sealed interface State: ViewState {
        data object Loading : State
        data class Success(val courses: List<Courses>) : State
        data class Error(val message: String) : State
        data object Empty : State
    }

    sealed interface Effect: ViewEffect{
        data class ShowError(val message: String) : Effect
        data object NavigateToDetails : Effect
    }

    sealed interface Event: ViewEvent{
        data object FetchCourses : Event
        data object ResetError : Event
    }

}