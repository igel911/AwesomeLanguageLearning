package com.example.awesomelanguagelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.home.ui.MainScreen
import com.example.awesomelanguagelearning.login_signup.ui.login.LoginScreen
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.ConfirmPasswordScreen
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.CreateAccountScreen
import com.example.awesomelanguagelearning.paging.ui.OnboardingScreen
import com.example.awesomelanguagelearning.splash.ui.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") { SplashScreen(
                            navigateToNextScreen = { navController.navigate("onboarding") }
                        ) }
                        composable("onboarding") { OnboardingScreen() }
                        composable("login") { LoginScreen() }
                        composable("sign_up_create") { CreateAccountScreen() }
                        composable("sign_up_confirm") { ConfirmPasswordScreen() }
                        composable("home") { MainScreen() }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        SplashScreen()
    }
}