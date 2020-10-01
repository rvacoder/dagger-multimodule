package com.example.calculator.di

import com.example.calculator.ui.LoginActivity
import com.example.core.di.CoreModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CalculatorModule::class,
        CoreModule::class
    ]
)
interface CalculatorComponent {

    fun inject(calculatorActivity: LoginActivity)

}