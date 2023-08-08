package com.example.weather.presentation.weather.search

import androidx.lifecycle.*
import com.example.weather.R
import com.example.weather.domain.weather.GetWeatherByNameUseCase
import com.example.weather.domain.weather.WeatherInfo
import com.example.weather.utils.ResourceProvider
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getWeatherByNameUseCase: GetWeatherByNameUseCase,
    private val resourceProvider: ResourceProvider,
): ViewModel() {

    private val _weatherInfo = MutableLiveData<WeatherInfo?>(null)
    val weatherInfo: LiveData<WeatherInfo?>
        get() = _weatherInfo

    private val _loading = MutableLiveData<Boolean>(false)
    val loading: LiveData<Boolean>
        get() = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    fun loadWeather(query: String?) {
        viewModelScope.launch {
            try {
                _loading.value = true
                getWeatherByNameUseCase(query).also { weatherInfo ->
                    _weatherInfo.value = weatherInfo
                }
            } catch (error: Throwable) {
                _error.value = resourceProvider.getString(R.string.error)
            } finally {
                _loading.value = false
            }
        }
    }

    suspend fun getWeatherByName(query: String?) = getWeatherByNameUseCase(query)

}
