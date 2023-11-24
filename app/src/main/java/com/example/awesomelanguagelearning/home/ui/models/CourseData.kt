package com.example.awesomelanguagelearning.home.ui.models

data class CourseData(
    val name: String,
    val difficulty: String,
    val classesQuantity: Int,
    val completedClasses: Int = 0,
    val isSelected: Boolean = false
)
