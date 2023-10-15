package com.example.awesomelanguagelearning.core.data.entity

import com.example.awesomelanguagelearning.core.domain.models.User
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


class UserEntity(
    var firstName: String,
    var lastName: String,
    var password: String,
    @PrimaryKey
    var email: String,
    var isActive: Boolean
) : RealmObject {

    @Suppress("unused")
    constructor() : this("", "", "", "", false)

    override fun toString(): String {
        return "[$firstName, $lastName, $email, $password, $isActive]"
    }

    fun toDomain(): User =
        User(
            firstName = firstName,
            lastName = lastName,
            password = password,
            email = email,
            isActive = isActive
        )
}