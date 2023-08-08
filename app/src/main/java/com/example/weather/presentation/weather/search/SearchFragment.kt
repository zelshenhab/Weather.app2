package com.example.weather.presentation.weather.search

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weather.R
import com.example.weather.databinding.FragmentSearchBinding
import com.example.weather.presentation.weather.WeatherUi
import com.example.weather.utils.hideKeyboard
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SearchFragment : DaggerFragment(R.layout.fragment_search) {
    private val binding by viewBinding(FragmentSearchBinding::bind)

    private val weatherUi = WeatherUi()

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: SearchViewModel by viewModels {
        factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()

        with(binding) {

            btSearch.setOnClickListener {
                val city = etSearch.text.toString()
                tvCityTempLabel.isVisible = true
                tvCityHumidityLabel.isVisible = true
                tvCityWindLabel.isVisible = true
                viewModel.loadWeather(city)
                view.hideKeyboard()
            }
        }
    }

    private fun observeViewModel() {
        with(viewModel) {

            weatherInfo.observe(viewLifecycleOwner) {
                if (it == null) return@observe
                binding.tvCityName.text = it.name
                showTemp(it.temperature)
                showWeatherIcon(it.icon)
                showHumidity(it.humidity)
                showHumidityIcon(it.humidity)
                showWindDirection(it.windDegree)
                showWindDirectionIcon(it.windDegree)
            }

            loading.observe(viewLifecycleOwner) {
                binding.progress.isVisible = it
            }

            error.observe(viewLifecycleOwner) {
                showError(it)
            }

        }
    }

    private fun showWeatherIcon(id: String?) {
        weatherUi.showWeatherIcon(binding.ivWeatherIcon, id)
    }

    private fun showHumidityIcon(humidity: Int) {
        weatherUi.showHumidityIcon(binding.ivHumidityIcon, humidity)
    }

    private fun showWindDirectionIcon(degree: Int) {
        weatherUi.showWindDirectionIcon(binding.ivDirectionIcon, degree)
    }

    private fun showTemp(temp: Double?) {
        weatherUi.showTemp(binding.tvCityTemp, temp)
    }

    private fun showHumidity(humidity: Int) {
        weatherUi.showHumidity(binding.tvCityHumidity, humidity)
    }

    private fun showWindDirection(degree: Int) {
        weatherUi.showWindDirection(binding.tvCityWind, degree)
    }

    private fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

}
