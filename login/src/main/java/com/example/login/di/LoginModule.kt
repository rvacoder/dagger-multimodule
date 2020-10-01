package com.example.login.di

import com.example.login.usecase.LoginUseCase
import com.example.core.resource.StringsProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LoginModule {

    @Provides
    @Singleton
    fun sumUseCase(stringsProvider: StringsProvider): LoginUseCase = LoginUseCase(stringsProvider)

}
