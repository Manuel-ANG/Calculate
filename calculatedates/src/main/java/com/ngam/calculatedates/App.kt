package com.ngam.calculatedates

import android.app.Application
import android.content.Context
import net.danlew.android.joda.JodaTimeAndroid

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setContext(this)
        JodaTimeAndroid.init(this)
    }

    companion object {
        private lateinit var mContext: Context
        fun setContext(context: Context) {
            this.mContext = context
        }

        fun getContext(): Context? = mContext
    }
}