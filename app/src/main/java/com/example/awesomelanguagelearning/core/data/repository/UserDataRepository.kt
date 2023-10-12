package com.example.awesomelanguagelearning.core.data.repository

import com.example.awesomelanguagelearning.core.data.entity.UserEntity
import com.example.awesomelanguagelearning.core.data.entity.toDomain
import com.example.awesomelanguagelearning.core.domain.models.User
import com.example.awesomelanguagelearning.core.domain.repository.UserRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query

class UserDataRepository(
    private val realm: Realm
) : UserRepository {

    override suspend fun getUserByMail(email: String): User? {
        return realm
            .query<UserEntity>("favoriteSnacks.name == $0", email)
            .first()
            .find()
            ?.toDomain()
    }

    override suspend fun doSignup(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): Boolean {
        val savedUser = realm.write {
            val userEntity = UserEntity(
                firstName = firstName,
                lastName = lastName,
                email = email,
                password = password,
                isActive = true
            )
            copyToRealm(userEntity)
        }
        return savedUser.firstName == firstName
                && savedUser.lastName == lastName
                && savedUser.email == email
                && savedUser.password == password
    }
}