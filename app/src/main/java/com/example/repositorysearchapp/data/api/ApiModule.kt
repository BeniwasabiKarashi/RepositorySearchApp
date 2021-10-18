package com.example.repositorysearchapp.data.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class WebApi

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesServiceModule {
    @Provides
    fun provideRepositoriesService(@WebApi retrofit: Retrofit): GitRepositoriesService =
        retrofit.create()
}

@Module
@InstallIn(SingletonComponent::class)
class WebApiRetrofitModule {
    @WebApi
    @Singleton
    @Provides
    fun provideWebApiRetrofit(client: OkHttpClient, json: Json): Retrofit {
        val contentType = MediaType.get("application/json; charset=utf-8")
        return Retrofit.Builder()
            .baseUrl(BASE_WEB_API_URL)
            .client(client)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    companion object {
        private const val BASE_WEB_API_URL = "https://api.github.com/"
    }
}

@Module
@InstallIn(SingletonComponent::class)
class JsonModule {
    @Singleton
    @Provides
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }
}