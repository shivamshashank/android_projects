package com.example.dependency_injections1

import android.util.Log
import javax.inject.Inject

class MemoryCard {

    init {
        Log.i("MyTag", "Memory Card Constructed")
    }

    fun getSpaceAvailability() {
        Log.i("MyTag", "Memory space available")
    }

}