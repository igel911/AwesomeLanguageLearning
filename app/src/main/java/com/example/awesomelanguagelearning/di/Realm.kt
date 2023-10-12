package com.example.awesomelanguagelearning.di

import com.example.awesomelanguagelearning.core.data.entity.UserEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

fun getRealm(): Realm {
    val config = RealmConfiguration.Builder(
        schema = setOf(
            UserEntity::class
        )
    ).apply {
        name("awesomeLanguageLearning.realm")
        deleteRealmIfMigrationNeeded()
    }.build()
    return Realm.open(config)
}
