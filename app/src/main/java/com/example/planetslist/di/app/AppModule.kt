package com.example.planetslist.di.app

import android.content.Context
import com.example.planetslist.PlanetsListApplication
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class AppContext

@Module
open class AppModule(private val app: PlanetsListApplication) {

    @Provides
    @AppContext
    fun provideAppContext(): Context = app

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient()
        .newBuilder()
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

}