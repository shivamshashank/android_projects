package com.example.dependency_injections1

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor() {

    init {
        Log.i("MyTag", "Service Provider Constructed")
    }

    fun getServiceProvider() {
        Log.i("MyTag", "Service Provider is connected")
    }

}