package com.ngam.dates

import android.app.Application
import com.ngam.calculatedates.InitializeApp

class Applications : Application() {

    override fun onCreate() {
        super.onCreate()
        InitializeApp(this)
    }
}