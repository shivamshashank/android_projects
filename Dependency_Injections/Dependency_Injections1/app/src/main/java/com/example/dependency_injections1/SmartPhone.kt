package com.example.dependency_injections1

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SmartPhone @Inject constructor(
    battery: Battery,
    simCard: SIMCard,
    memoryCard: MemoryCard,
) {

    init {
        battery.getPower()
        simCard.getConnection()
        memoryCard.getSpaceAvailability()

        Log.i("MyTag", "SmartPhone Constructed")
    }

    fun makeACallWithRecording() {
        Log.i("MyTag", "Calling.....")
    }
}