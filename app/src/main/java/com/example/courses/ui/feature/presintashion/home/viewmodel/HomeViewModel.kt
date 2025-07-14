package com.example.courses.ui.feature.presintashion.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.ui.feature.presintashion.home.datasource.model.CoursesList
import com.example.data.ui.feature.presintashion.home.datasource.repository.CoursesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CoursesRepository
) : ViewModel() {

    private val _courses = MutableStateFlow<CoursesList>(CoursesList(emptyList()))
    val courses: StateFlow<CoursesList> = _courses

    fun handleEvent(event: HomeContract.Event) {
        when (event) {
            HomeContract.Event.FetchCourses -> fetchCourses()
        }
    }

    private fun fetchCourses() {
        viewModelScope.launch {
            _courses.value = repository.getCourses()
        }
    }

}