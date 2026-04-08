package com.ngam.calculatedates

import android.app.Application
import net.danlew.android.joda.JodaTimeAndroid

class InitializeApp(private val aplicacion: Application) {
    init {
        JodaTimeAndroid.init(aplicacion)
    }
}