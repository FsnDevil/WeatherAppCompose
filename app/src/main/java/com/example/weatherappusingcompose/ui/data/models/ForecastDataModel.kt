package com.example.weatherappusingcompose.ui.data.models

data class ForecastDataModel(
    val city: City?=null,
    val cnt: Int?=null,
    val cod: String?=null,
    val list: List<ForecastData>?=null,
    val message: Int?=null
)