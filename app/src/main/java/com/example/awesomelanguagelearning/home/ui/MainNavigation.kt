package com.example.awesomelanguagelearning.home.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Addchart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Task
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Addchart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Task
import androidx.compose.ui.graphics.vector.ImageVector

sealed class MainNavigation(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    object Home: MainNavigation(
        route = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
        )
    object Task: MainNavigation(
        route = "Task",
        selectedIcon = Icons.Filled.Task,
        unselectedIcon = Icons.Outlined.Task
    )
    object Stats: MainNavigation(
        route = "Stats",
        selectedIcon = Icons.Filled.Addchart,
        unselectedIcon = Icons.Outlined.Addchart
    )
    object Profile: MainNavigation(
        route = "Profile",
        selectedIcon = Icons.Filled.AccountCircle,
        unselectedIcon = Icons.Outlined.AccountCircle
    )

}