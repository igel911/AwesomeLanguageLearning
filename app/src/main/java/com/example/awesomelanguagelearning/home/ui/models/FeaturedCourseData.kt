package com.example.awesomelanguagelearning.home.ui.models


data class FeaturedCourseData(
    val name: String,
    val type: String,
    val duration: Int,
    val isSelected: Boolean = false
)
