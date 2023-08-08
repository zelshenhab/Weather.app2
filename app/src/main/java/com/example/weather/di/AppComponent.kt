package com.example.weather.di

import android.content.Context
import com.example.weather.App
import com.example.weather.utils.ResourceProvider
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetWorkModule::class,
        WeatherModule::class,
        ViewModelModule::class,
        FeatureModule::class,
    ]
)
@Singleton
interface AppComponent {

    fun provideContext(): Context

    fun provideResourceProvider(): ResourceProvider

    fun inject(application: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(applicationContext: Context): Builder

        fun build(): AppComponent
    }

}
