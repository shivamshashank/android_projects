package com.example.coroutine2

import kotlinx.coroutines.*

class UserDataManager1 {
    private var userId = 0

    // Unstructured Concurrency
    suspend fun getUserId() : Int{
        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            userId = 50
        }

        val deferred = CoroutineScope(Dispatchers.IO).async {
            delay(5000)
            return@async 70
        }

        return userId + deferred.await()
    }
}