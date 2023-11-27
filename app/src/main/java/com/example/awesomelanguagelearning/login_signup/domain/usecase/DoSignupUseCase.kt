package com.example.awesomelanguagelearning.login_signup.domain.usecase

import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.domain.models.User
import com.example.awesomelanguagelearning.core.domain.repository.UserRepository
import com.example.awesomelanguagelearning.core.ui.utils.coroutines.DispatcherProvider
import com.example.awesomelanguagelearning.core.ui.utils.resource_provider.AppResourceProvider
import com.example.awesomelanguagelearning.login_signup.domain.entity.SignupResult
import kotlinx.coroutines.withContext

class DoSignupUseCase(
    private val dispatcherProvider: DispatcherProvider,
    private val userRepository: UserRepository,
    private val resourceProvider: AppResourceProvider
) {

    suspend operator fun invoke(user: User): SignupResult {
        return withContext(dispatcherProvider.io) {
            try {
                val isSignupSuccessful = userRepository.doSignup(
                    firstName = user.firstName,
                    lastName = user.lastName,
                    email = user.email,
                    password = user.password
                )
                SignupResult(isSignupSuccessful)
            } catch (e: IllegalArgumentException) {
                SignupResult(
                    isSuccessful = false,
                    errorMessage = resourceProvider.getString(R.string.user_already_exist)
                )
            } catch (e: IllegalStateException) {
                //todo find out what the hell it happens
                SignupResult(
                    isSuccessful = false,
                    errorMessage = resourceProvider.getString(R.string.unexpected_error)
                )
            }
        }
    }
}