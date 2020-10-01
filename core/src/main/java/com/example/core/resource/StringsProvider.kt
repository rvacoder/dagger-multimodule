package com.example.core.resource

import android.app.Application
import androidx.annotation.StringRes

class StringsProvider(private val application: Application) {

    fun getString(@StringRes id: Int): String = application.getString(id)

}