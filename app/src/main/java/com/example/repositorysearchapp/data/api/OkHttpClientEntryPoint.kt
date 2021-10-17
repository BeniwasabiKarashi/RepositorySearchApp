package com.example.repositorysearchapp.data.api

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

@EntryPoint
@InstallIn(SingletonComponent::class)
interface OkHttpClientEntryPoint {
    fun getOkHttpClient(): OkHttpClient
}