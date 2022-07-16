package com.example.dependency_injections1

import android.app.Application

class SmartPhoneApplication : Application() {
    lateinit var smartPhoneComponent: SmartPhoneComponent

    override fun onCreate() {
        super.onCreate()

        smartPhoneComponent = initDagger()
    }

    private fun initDagger(): SmartPhoneComponent =
        DaggerSmartPhoneComponent
            .builder()
            .memoryCardModule(MemoryCardModule(1024))
            .build()

}