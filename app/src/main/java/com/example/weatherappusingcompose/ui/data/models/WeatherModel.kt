package com.example.weatherappusingcompose.ui.data.models


data class WeatherModel(
  var dt: Int? = null,
  var main: Main? = Main(),
  var weather: ArrayList<Weather> = arrayListOf(),
  var clouds: Clouds? = Clouds(),
  var wind: Wind? = Wind(),
  var visibility: Int? = null,
  var pop: Int? = null,
  var sys: Sys? = Sys(),
  var dt_txt: String? = null
)