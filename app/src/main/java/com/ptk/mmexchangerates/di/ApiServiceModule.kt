package com.ptk.mmexchangerates.di

import com.ptk.mmexchangerates.data_source.remote.ApiService
import com.ptk.mmexchangerates.data_source.remote.ApiServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Provides
    @Singleton
    fun provideApiService(apiService: ApiServiceImpl): ApiService = apiService


}