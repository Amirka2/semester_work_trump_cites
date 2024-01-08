package com.example.trumpcites.di

import android.content.Context
import com.example.trumpcites.App

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }