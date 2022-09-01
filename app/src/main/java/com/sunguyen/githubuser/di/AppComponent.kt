package com.sunguyen.githubuser.di

import com.sunguyen.githubuser.MyApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(app: MyApplication)
}