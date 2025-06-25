package com.swapi.planets

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SwapiApp : Application() {

    override fun onCreate() {
        super.onCreate()

    }
}