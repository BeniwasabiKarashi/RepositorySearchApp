package com.example.repositorysearchapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class RepositorySearchApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
    }
    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}