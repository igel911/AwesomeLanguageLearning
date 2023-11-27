package com.example.awesomelanguagelearning.di

import com.example.awesomelanguagelearning.chooseLanguage.domain.usecase.GetChooseLanguageContentUseCase
import com.example.awesomelanguagelearning.chooseLanguage.ui.ChooseLanguageViewModel
import com.example.awesomelanguagelearning.core.data.repository.UserDataRepository
import com.example.awesomelanguagelearning.core.domain.repository.UserRepository
import com.example.awesomelanguagelearning.core.ui.utils.coroutines.AppDispatcherProvider
import com.example.awesomelanguagelearning.core.ui.utils.coroutines.DispatcherProvider
import com.example.awesomelanguagelearning.core.ui.utils.resource_provider.AppResourceProvider
import com.example.awesomelanguagelearning.core.ui.utils.resource_provider.ResourceProvider
import com.example.awesomelanguagelearning.forgot_password.ui.ForgotPasswordViewModel
import com.example.awesomelanguagelearning.home.ui.HomeViewModel
import com.example.awesomelanguagelearning.login_signup.domain.usecase.DoSignupUseCase
import com.example.awesomelanguagelearning.login_signup.ui.validator.ConfirmPasswordValidator
import com.example.awesomelanguagelearning.login_signup.ui.validator.CreateAccountValidator
import com.example.awesomelanguagelearning.login_signup.ui.validator.EmailValidator
import com.example.awesomelanguagelearning.login_signup.ui.validator.NameValidator
import com.example.awesomelanguagelearning.login_signup.ui.validator.PasswordValidator
import com.example.awesomelanguagelearning.login_signup.ui.validator.RepeatedPasswordValidator
import com.example.awesomelanguagelearning.login_signup.ui.login.LoginViewModel
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.SignupViewModel
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
    viewModelOf(::HomeViewModel)
    viewModelOf(::ChooseLanguageViewModel)
    viewModelOf(::ForgotPasswordViewModel)
    viewModelOf(::SignupViewModel)
}

val utilModule = module {
    singleOf(::AppDispatcherProvider) { bind<DispatcherProvider>() }
    singleOf(::AppResourceProvider) { bind<ResourceProvider>() }
}

val useCaseModule = module {
    singleOf(::GetChooseLanguageContentUseCase)
    singleOf(::DoSignupUseCase)
}

val repositoryModule = module {
    singleOf(::UserDataRepository) { bind<UserRepository>() }
}

val dataBaseModule = module {
    single { getRealm() }
}

val validatorModule = module {
    singleOf(::NameValidator)
    singleOf(::EmailValidator)
    singleOf(::PasswordValidator)
    singleOf(::RepeatedPasswordValidator)
    singleOf(::CreateAccountValidator)
    singleOf(::ConfirmPasswordValidator)
}