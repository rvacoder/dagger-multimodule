package com.example.core.di

import com.example.core.modes.AppSubscription
import com.example.core.resource.StringsProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [CoreModule::class])
class SubscriptionModule {

    @Provides
    @Singleton
    fun appSubscription(
        stringsProvider: StringsProvider
    ): AppSubscription = AppSubscription(stringsProvider)

}