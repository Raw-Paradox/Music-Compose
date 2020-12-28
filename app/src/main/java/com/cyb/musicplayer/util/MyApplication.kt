package com.cyb.musicplayer.util

import android.app.Application
import android.content.Context

/**
 * Created by Paradoox on 2020/12/25.
 */
class MyApplication : Application() {
    companion object{
        lateinit var globalContext: Context
        private set
    }

    override fun onCreate() {
        super.onCreate()
        globalContext = applicationContext
    }
}