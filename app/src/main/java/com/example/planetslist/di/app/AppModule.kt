package com.example.planetslist.di.app

import android.content.Context
import com.example.planetslist.PlanetsListApplication
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
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
    @Reusable
    internal fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl("")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()

}