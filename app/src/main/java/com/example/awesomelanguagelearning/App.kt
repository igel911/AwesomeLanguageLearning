package com.example.awesomelanguagelearning

import android.app.Application
import com.example.awesomelanguagelearning.di.dataBaseModule
import com.example.awesomelanguagelearning.di.repositoryModule
import com.example.awesomelanguagelearning.di.useCaseModule
import com.example.awesomelanguagelearning.di.utilModule
import com.example.awesomelanguagelearning.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(
                viewModelModule,
                utilModule,
                useCaseModule,
                repositoryModule,
                dataBaseModule
                )
        }
    }
}