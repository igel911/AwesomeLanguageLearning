package com.example.awesomelanguagelearning.core.ui.navigation

sealed class AppNavigation(val route: String) {
    object Splash: AppNavigation(route = "splash")

    object Onboarding: AppNavigation(route = "onboarding")

    object Login: AppNavigation(route = "login")

    object Signup: AppNavigation(route = "sign_up")

    object ChooseLanguage: AppNavigation(route = "choose_language")

    object ChooseLanguageFinal: AppNavigation(route = "choose_language_final")

    object ForgotPassword: AppNavigation(route = "forgot_password")

    object Main: AppNavigation(route = "main")
}
