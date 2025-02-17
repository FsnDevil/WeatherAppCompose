package com.example.weatherappusingcompose.ui.screens.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappusingcompose.ui.data.models.WeatherResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val weatherRepository: WeatherRepository) : ViewModel() {

    val weatherResponse:StateFlow<WeatherResponse> = weatherRepository.forecastModel
    val forecastError:StateFlow<String> = weatherRepository.forecastError
    val isLoading:StateFlow<Boolean> = weatherRepository.isLoading

    init {
        viewModelScope.launch {
            weatherRepository.getForecastData()
        }
    }


}