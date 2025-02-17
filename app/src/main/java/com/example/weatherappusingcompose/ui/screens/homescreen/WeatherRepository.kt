package com.example.weatherappusingcompose.ui.screens.homescreen

import androidx.compose.ui.res.stringResource
import com.example.weatherappusingcompose.R
import com.example.weatherappusingcompose.ui.data.models.WeatherResponse
import com.example.weatherappusingcompose.ui.data.remote.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiService: ApiService) {

    private var _forecastModel = MutableStateFlow(WeatherResponse())
    var forecastModel: StateFlow<WeatherResponse> = _forecastModel

    private var _forecastError = MutableStateFlow("")
    var forecastError = _forecastError.asStateFlow()

    private var _isLoading = MutableStateFlow(false)
    var isLoading = _isLoading.asStateFlow()

    suspend fun getForecastData(){
        try {
            _isLoading.value = true
            val response = apiService.getForecastData("Pune", "1a008f09d9c43c7d7ef7061b96b610eb")
            if (response.isSuccessful && response.body() != null) {
                _forecastModel.emit(response.body()!!)
                _isLoading.value = false
            } else {
                _forecastError.emit("Something Went Wrong please try again..")
                _isLoading.value = false
            }
        } catch (e: Exception) {
            e.localizedMessage?.let { _forecastError.emit(it) }
            _isLoading.value = false
        }
    }
}