package com.example.awesomelanguagelearning.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.awesomelanguagelearning.chooseLanguage.ui.ChooseLanguageFinalScreen
import com.example.awesomelanguagelearning.chooseLanguage.ui.ChooseLanguageScreen
import com.example.awesomelanguagelearning.forgot_password.ui.ForgotPasswordScreen
import com.example.awesomelanguagelearning.home.ui.MainScreen
import com.example.awesomelanguagelearning.login_signup.ui.login.LoginScreen
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.ConfirmPasswordScreen
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.CreateAccountScreen
import com.example.awesomelanguagelearning.paging.ui.OnboardingScreen
import com.example.awesomelanguagelearning.splash.ui.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AppNavigation.Splash.route
    ) {
        composable(AppNavigation.Splash.route) {
            SplashScreen(
                navigateToNextScreen = { navController.navigate(AppNavigation.Onboarding.route) }
            )
        }
        composable(AppNavigation.Onboarding.route) {
            OnboardingScreen(
                onChooseLanguageClick = { navController.navigate(AppNavigation.ChooseLanguage.route) },
                onLoginClick = { navController.navigate(AppNavigation.Login.route) }
            )
        }
        composable(AppNavigation.Login.route) {
            LoginScreen(
                navigateToNextScreen = { navController.navigate(AppNavigation.Main.route) },
                goToSignup = { navController.navigate(AppNavigation.CreateAccount.route) },
                doLoginByFacebook = { },
                doLoginByGoogle = { },
                goToForgotPassword = { navController.navigate(AppNavigation.ForgotPassword.route) },
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(AppNavigation.CreateAccount.route) {
            CreateAccountScreen(
                navigateToNextScreen = { navController.navigate(AppNavigation.ConfirmPassword.route) },
                goToLogin = { navController.navigate(AppNavigation.Login.route) },
                doLoginByFacebook = { },
                doLoginByGoogle = { },
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(AppNavigation.ConfirmPassword.route) {
            ConfirmPasswordScreen(
                navigateToNextScreen = { navController.navigate(AppNavigation.Main.route) },
                goToLogin = { navController.navigate(AppNavigation.Login.route) },
                doLoginByFacebook = { },
                doLoginByGoogle = { },
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(AppNavigation.ChooseLanguage.route) {
            ChooseLanguageScreen(
                navigateToNextScreen = { navController.navigate(AppNavigation.ChooseLanguageFinal.route) },
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(AppNavigation.ChooseLanguageFinal.route) {
            ChooseLanguageFinalScreen(
                navigateToNextScreen = { navController.navigate(AppNavigation.Login.route) },
                navigateBack = { navController.popBackStack() }
            )

        }
        composable(AppNavigation.ForgotPassword.route) {
            ForgotPasswordScreen(
                navigateBack = { navController.popBackStack() }
            )

        }
        composable(AppNavigation.Main.route) { MainScreen() }
    }
}