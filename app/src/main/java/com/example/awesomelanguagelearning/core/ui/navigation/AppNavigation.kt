package com.example.awesomelanguagelearning.core.ui.navigation

sealed class AppNavigation(val route: String) {
    object Splash: AppNavigation(route = "splash")

    object Onboarding: AppNavigation(route = "onboarding")

    object Login: AppNavigation(route = "login")

    object CreateAccount: AppNavigation(route = "sign_up_create")

    object ConfirmPassword: AppNavigation(route = "sign_up_confirm")

    object ChooseLanguage: AppNavigation(route = "choose_language")

    object ChooseLanguageFinal: AppNavigation(route = "choose_language_final")

    object Main: AppNavigation(route = "main")
}
