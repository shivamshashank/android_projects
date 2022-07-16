package com.example.dependency_injections1

import android.util.Log
import javax.inject.Inject

class NickelCadmiumBattery @Inject constructor() : Battery {
    override fun getPower() {
        Log.i("MyTag", "Power from Nickel Cadmium Battery")
    }
}