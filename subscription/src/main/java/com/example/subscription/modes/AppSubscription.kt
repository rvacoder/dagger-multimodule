package com.example.core.modes

import com.example.core.R
import com.example.core.resource.StringsProvider

class AppSubscription(private val stringsProvider: StringsProvider) {

    fun getUserSubscription(): String {
        return stringsProvider.getString(R.string.suscription_free_title)
    }


}

