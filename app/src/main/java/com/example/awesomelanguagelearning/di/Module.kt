package com.example.awesomelanguagelearning.di

import com.example.awesomelanguagelearning.login_signup.ui.login.LoginViewModel
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.ConfirmPasswordViewModel
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.CreateAccountViewModel
import com.example.awesomelanguagelearning.paging.ui.OnboardingViewModel
import com.example.awesomelanguagelearning.splash.ui.SplashViewModel
import com.example.awesomelanguagelearning.home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::SplashViewModel)
    viewModelOf(::OnboardingViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::ConfirmPasswordViewModel)
    viewModelOf(::CreateAccountViewModel)
    viewModelOf(::HomeViewModel)
}