package com.example.awesomelanguagelearning.home.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.awesomelanguagelearning.home.ui.views.HomeScreen
import com.example.awesomelanguagelearning.home.ui.views.ProfileScreen
import com.example.awesomelanguagelearning.home.ui.views.StatsScreen
import com.example.awesomelanguagelearning.home.ui.views.TaskScreen

@Composable
fun MainNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MainNavigation.Home.route
    ) {
        composable(MainNavigation.Home.route) { HomeScreen() }
        composable(MainNavigation.Task.route) { TaskScreen() }
        composable(MainNavigation.Stats.route) { StatsScreen() }
        composable(MainNavigation.Profile.route) { ProfileScreen() }
    }
}