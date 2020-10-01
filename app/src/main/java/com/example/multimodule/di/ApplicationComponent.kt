package com.example.multimodule.di

import com.example.core.di.SubscriptionModule
import com.example.multimodule.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        SubscriptionModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

}