package com.example.awesomelanguagelearning.di

import com.example.awesomelanguagelearning.chooseLanguage.domain.usecase.GetChooseLanguageContentUseCase
import com.example.awesomelanguagelearning.chooseLanguage.ui.ChooseLanguageViewModel
import com.example.awesomelanguagelearning.core.ui.utils.coroutines.AppDispatcherProvider
import com.example.awesomelanguagelearning.core.ui.utils.coroutines.DispatcherProvider
import com.example.awesomelanguagelearning.core.ui.utils.resource_provider.AppResourceProvider
import com.example.awesomelanguagelearning.core.ui.utils.resource_provider.ResourceProvider
import com.example.awesomelanguagelearning.home.ui.HomeViewModel
import com.example.awesomelanguagelearning.login_signup.ui.login.LoginViewModel
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.ConfirmPasswordViewModel
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.CreateAccountViewModel
import com.example.awesomelanguagelearning.paging.ui.OnboardingViewModel
import com.example.awesomelanguagelearning.splash.ui.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::SplashViewModel)
    viewModelOf(::OnboardingViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::ConfirmPasswordViewModel)
    viewModelOf(::CreateAccountViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::ChooseLanguageViewModel)
}

val utilModule = module {
    singleOf(::AppDispatcherProvider) { bind<DispatcherProvider>() }
    singleOf(::AppResourceProvider) { bind<ResourceProvider>() }
}

val useCaseModule = module {
    singleOf(::GetChooseLanguageContentUseCase)
}