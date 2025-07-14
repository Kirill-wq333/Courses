package com.example.courses.ui.feature.presintashion.favourite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courses.ui.feature.presintashion.home.viewmodel.HomeContract
import com.example.domain.ui.feature.presintashion.home.model.CoursesList
import com.example.domain.ui.feature.presintashion.home.repository.CoursesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val repository: CoursesRepository
) : ViewModel() {

    private val _courses = MutableStateFlow<CoursesList>(
        CoursesList(emptyList())
    )
    val courses: StateFlow<CoursesList> = _courses

    fun handleEvent(event: FavouriteContract.Event) {
        when (event) {
            FavouriteContract.Event.FetchCourses -> fetchCourses()
        }
    }

    private fun fetchCourses() {
        viewModelScope.launch {
            _courses.value = repository.getCourses()
        }
    }
}