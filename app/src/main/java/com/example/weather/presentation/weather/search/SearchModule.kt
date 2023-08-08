package com.example.weather.presentation.weather.search

import androidx.lifecycle.ViewModel
import com.example.weather.di.FeatureScope
import com.example.weather.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SearchModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    @FeatureScope
    fun provideViewModel(viewModel: SearchViewModel): ViewModel
}
