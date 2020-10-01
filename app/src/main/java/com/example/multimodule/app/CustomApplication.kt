package com.example.multimodule.app

import android.app.Application
import com.example.login.di.LoginComponent
import com.example.login.di.DaggerLoginComponent
import com.example.login.di.provider.LoginComponentProvider
import com.example.core.di.CoreModule
import com.example.multimodule.di.ApplicationComponent
import com.example.multimodule.di.DaggerApplicationComponent
import com.example.multimodule.di.provider.ApplicationComponentProvider

class CustomApplication : Application(),
    LoginComponentProvider,
    ApplicationComponentProvider {

    private val coreModule: CoreModule by lazy {
        CoreModule(this)
    }

    override fun getLoginComponent(): LoginComponent {
        return DaggerLoginComponent.builder()
            .coreModule(coreModule)
            .build()
    }

    override fun getApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .coreModule(coreModule)
            .build()
    }

}