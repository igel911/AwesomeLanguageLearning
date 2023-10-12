package com.example.awesomelanguagelearning.login_signup.domain.usecase

import com.example.awesomelanguagelearning.core.domain.models.User
import com.example.awesomelanguagelearning.core.domain.repository.UserRepository
import com.example.awesomelanguagelearning.core.ui.utils.coroutines.DispatcherProvider
import com.example.awesomelanguagelearning.login_signup.domain.entity.SignupResult
import kotlinx.coroutines.withContext

class DoSignupUseCase(
    private val dispatcherProvider: DispatcherProvider,
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(user: User): SignupResult {
        return withContext(dispatcherProvider.io) {
            when {
                user.arePasswordsNotEqual -> SignupResult(false)
                else -> {
                    val isSignupSuccessful = userRepository.doSignup(
                        firstName = user.firstName,
                        lastName = user.lastName,
                        email = user.email,
                        password = user.password
                    )
                    SignupResult(isSignupSuccessful)
                }
            }
        }
    }
}