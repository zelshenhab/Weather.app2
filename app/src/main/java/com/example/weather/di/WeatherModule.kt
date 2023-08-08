package com.example.weather.di

import dagger.Module
import dagger.Provides
import com.example.weather.data.weather.WeatherApiRepositoryImpl
import com.example.weather.data.weather.datasource.remote.WeatherApi
import com.example.weather.domain.weather.*

@Module
class WeatherModule {

    @Provides
    fun provideWeatherRepository(
        weatherApi: WeatherApi
    ): WeatherApiRepository = WeatherApiRepositoryImpl(weatherApi)

    @Provides
    fun provideWeatherByNameUseCase(
        repository: WeatherApiRepository
    ): GetWeatherByNameUseCase = GetWeatherByNameUseCase(repository)

}
