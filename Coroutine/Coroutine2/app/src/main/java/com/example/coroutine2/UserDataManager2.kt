package com.example.coroutine2

import kotlinx.coroutines.*

class UserDataManager2 {
    private var userId = 0
    private lateinit var deferred: Deferred<Int>

    // Structured Concurrency
    suspend fun getUserId(): Int {
        coroutineScope {
            launch(Dispatchers.IO) {
                delay(3000)
                userId = 50
            }

            deferred = async(Dispatchers.IO) {
                delay(5000)
                return@async 70
            }
        }

        return userId + deferred.await()
    }
}