package com.example.dependency_injections1

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule (private val memorySize: Int) {

    @Provides
    fun providesMemoryCard() : MemoryCard{
        Log.i("MyTag","Size of the memory is $memorySize")
        return  MemoryCard()
    }
}