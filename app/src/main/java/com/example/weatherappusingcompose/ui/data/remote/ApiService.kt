package com.example.weatherappusingcompose.ui.data.remote

import com.example.weatherappusingcompose.ui.data.models.ForecastDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("data/2.5/forecast")
    suspend fun getForecastData(@Query("q")cityName:String,@Query("APPID")appId:String): Response<ForecastDataModel>
}