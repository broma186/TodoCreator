package com.example.gitrepositoryhub

import android.app.Application
import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import di.DaggerAppComponent
import javax.inject.Inject

/*
Application class set up for the intention of dependency injection.
 */
class TodoApplication : Application(), HasAndroidInjector  {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    val context : Context = this

    override fun onCreate() {
        DaggerAppComponent.create().inject(this)
        super.onCreate()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector;
    }
}