package com.example.myhealth

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import android.os.Bundle
import android.os.IBinder
import android.os.Looper
import android.os.Messenger
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitInstance {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val ninjasApiService: NinjasApiService by lazy {
        retrofit.create(NinjasApiService::class.java)
    }
}


