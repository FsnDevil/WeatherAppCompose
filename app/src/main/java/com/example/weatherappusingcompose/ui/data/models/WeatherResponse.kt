package com.example.weatherappusingcompose.ui.data.models


data class WeatherResponse(
  var cod: String? = null,
  var message: Int? = null,
  var cnt: Int? = null,
  var list: List<WeatherModel>?= null,
  var city: City? = City()
)