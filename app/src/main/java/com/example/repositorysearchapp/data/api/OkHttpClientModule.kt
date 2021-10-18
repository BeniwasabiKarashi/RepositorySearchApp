package com.example.repositorysearchapp.data.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OkHttpClientModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor(
                    HttpLoggingInterceptor.Logger {
                        Timber.d(it)
                    }
                ).apply { level = HttpLoggingInterceptor.Level.BODY }
            )
            .build()
    }
}