package com.example.gitrepositoryhub

import android.app.Application
import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import di.AppComponent
import di.DaggerAppComponent
import javax.inject.Inject

/*
Application class set up for the intention of dependency injection.
 */
class TodoApplication : Application(), HasAndroidInjector  {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private lateinit var appComponent: AppComponent

    val context : Context = this

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector;
    }
}