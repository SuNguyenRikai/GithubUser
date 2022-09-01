package com.sunguyen.githubuser

import android.app.Application
import com.sunguyen.githubuser.di.AppComponent
import com.sunguyen.githubuser.di.DaggerAppComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class MyApplication : Application(){
    companion object {
        lateinit var instance: MyApplication
            private set
    }

    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        instance = this
        initComponent()
    }

    private fun initComponent() {
        appComponent = DaggerAppComponent.builder()
            .build()
        appComponent.inject(this)
    }
}