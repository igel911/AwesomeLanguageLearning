package com.example.awesomelanguagelearning.core.domain.repository

import com.example.awesomelanguagelearning.core.domain.models.User

interface UserRepository {

    suspend fun getUserByMail(email: String): User?

    suspend fun doSignup(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): Boolean

}