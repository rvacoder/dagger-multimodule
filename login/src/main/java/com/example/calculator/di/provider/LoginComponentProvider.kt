package com.example.calculator.di.provider

import com.example.calculator.di.CalculatorComponent

interface LoginComponentProvider {

    fun getCalculatorComponent(): CalculatorComponent

}