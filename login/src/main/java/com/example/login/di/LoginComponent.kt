package com.example.login.di

import com.example.login.ui.LoginActivity
import com.example.core.di.CoreModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        LoginModule::class,
        CoreModule::class
    ]
)
interface LoginComponent {

    fun inject(loginActivity: LoginActivity)

}