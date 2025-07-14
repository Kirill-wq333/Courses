package com.example.courses.ui.feature.presintashion.home.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ui.feature.presintashion.home.model.CoursesList
import com.example.domain.ui.feature.presintashion.home.repository.CoursesRepository
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

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun handleEvent(event: HomeContract.Event) {
        when (event) {
           is HomeContract.Event.FetchCourses -> fetchCourses()
           is HomeContract.Event.SearchCourses -> searchCourses(event.query)
        }
    }

    private fun fetchCourses() {
        viewModelScope.launch {
            _courses.value = repository.getCourses()
        }
    }

   private fun searchCourses(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _courses.value = repository.searchCourses(query)
            _isLoading.value = false
        }
    }

}