package com.example.planetslist

import android.app.Application
import com.example.planetslist.di.app.AppComponent
import com.example.planetslist.di.app.AppModule
import com.example.planetslist.di.app.DaggerAppComponent

class PlanetsListApplication : Application() {

    private val appModule = AppModule(this)
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(appModule)
            .build()
        appComponent.inject(this)
    }
}