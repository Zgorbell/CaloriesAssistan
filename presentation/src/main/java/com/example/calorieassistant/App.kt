package com.example.calorieassistant

import android.app.Application
import com.example.remote.RestApi
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class App: Application(){

    public lateinit var restApi: RestApi

    companion object{
        private lateinit var instance: App
        fun getInstance(): App{
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        val okhttp = OkHttpClient().newBuilder()
            .callTimeout(20, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(okhttp)
            .baseUrl(RestApi.BASE_URL)
            .build()
        restApi = retrofit.create(RestApi::class.java)
    }
}