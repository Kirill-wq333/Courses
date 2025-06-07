package com.example.courses.ui.feature.presintashion.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.ui.feature.presintashion.home.datasource.dto.Courses
import com.example.data.ui.feature.presintashion.home.datasource.repository.CoursesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: CoursesRepository
) : ViewModel() {

    private val _courses = MutableStateFlow<List<Courses>>(emptyList())
    val courses: StateFlow<List<Courses>> = _courses

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun handleEvent(event: HomeContract.Event) {
        when (event) {
            HomeContract.Event.FetchCourses -> fetchCourses()
            HomeContract.Event.ResetError -> resetError()
        }
    }

    fun fetchCourses() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val result = repository.getCourses(
                    "u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hq-BbS8-q&export=download"
                )
                _courses.value = result
            } catch (e: Exception) {
                _error.value = "Ошибка загрузки: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun resetError() {
        _error.value = null
    }
}