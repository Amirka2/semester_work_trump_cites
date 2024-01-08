package com.example.trumpcites

import android.app.Application
import com.example.trumpcites.di.AppComponent
import com.example.trumpcites.di.DaggerAppComponent

class App: Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build()
    }
}

