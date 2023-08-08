package com.example.weather.utils

import android.content.Context

class ResourceProviderImpl(
    private val context: Context
): ResourceProvider {

    override fun getString(id: Int): String {
        return context.getString(id)
    }

}
