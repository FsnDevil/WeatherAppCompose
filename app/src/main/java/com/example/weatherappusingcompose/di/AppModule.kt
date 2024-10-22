package com.example.weatherappusingcompose.di

import com.example.weatherappusingcompose.ui.data.remote.ApiService
import com.example.weatherappusingcompose.ui.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun provideApiService():ApiService{
        return RetrofitClient.apiService
    }
}