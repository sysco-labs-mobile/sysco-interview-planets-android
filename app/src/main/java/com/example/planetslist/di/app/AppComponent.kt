package com.example.planetslist.di.app

import android.content.Context
import com.example.planetslist.MainActivity
import com.example.planetslist.PlanetsListApplication
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @AppContext
    fun appContext(): Context

    fun retrofit(): Retrofit
    fun okHttpClient(): OkHttpClient

    fun inject(app: PlanetsListApplication)
    fun inject(activity: MainActivity)
}