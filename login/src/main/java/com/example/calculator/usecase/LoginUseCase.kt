package com.example.calculator.usecase

import com.example.calculator.R
import com.example.core.resource.StringsProvider

class LoginUseCase(private val stringsProvider: StringsProvider) {

    fun execute(user: String, password: String): Result {
        return if (user == "globant" && password == "12345") {
            Result.Success(String.format(stringsProvider.getString(R.string.login_success), user))
        } else {
            Result.Failure(stringsProvider.getString(R.string.login_fail))
        }
    }

    sealed class Result {
        class Success(val result: String) : Result()
        class Failure(val message: String) : Result()
    }

}