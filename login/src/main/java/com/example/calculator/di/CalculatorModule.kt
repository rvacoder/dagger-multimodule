package com.example.calculator.di

import com.example.calculator.usecase.LoginUseCase
import com.example.core.resource.StringsProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CalculatorModule {

    @Provides
    @Singleton
    fun sumUseCase(
        stringsProvider: StringsProvider
    ): LoginUseCase = LoginUseCase(stringsProvider)

}
