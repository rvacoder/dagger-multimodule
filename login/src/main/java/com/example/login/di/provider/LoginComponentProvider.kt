package com.example.login.di.provider

import com.example.login.di.LoginComponent

interface LoginComponentProvider {

    fun getLoginComponent(): LoginComponent

}