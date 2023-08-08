package com.example.weather.di

import android.content.Context
import com.example.weather.utils.ResourceProvider
import com.example.weather.utils.ResourceProviderImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideResourceProvider(
        context: Context
    ): ResourceProvider = ResourceProviderImpl(context)

}
