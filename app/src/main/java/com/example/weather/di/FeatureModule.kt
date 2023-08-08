package com.example.weather.di

import com.example.weather.presentation.weather.search.SearchFragment
import com.example.weather.presentation.weather.search.SearchModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FeatureModule {

    @FeatureScope
    @ContributesAndroidInjector(modules = [SearchModule::class])
    fun contributeSearchFragment(): SearchFragment

}
