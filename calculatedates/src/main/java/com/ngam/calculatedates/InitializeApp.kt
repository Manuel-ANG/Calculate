package com.ngam.calculatedates

import android.app.Application
import android.content.Context
import net.danlew.android.joda.JodaTimeAndroid

class InitializeApp(private val aplicacion: Application) {
    init {
        setContext(aplicacion)
        JodaTimeAndroid.init(aplicacion)
    }

    companion object {
        private lateinit var mContext: Context
        fun setContext(context: Context) {
            this.mContext = context
        }

        fun getContext(): Context? = mContext
    }
}