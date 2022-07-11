package com.example.coroutine2.repository

import com.example.coroutine2.model.User
import kotlinx.coroutines.delay

@Suppress("UnnecessaryVariable")
class UserRepository {

    suspend fun getUsers(): List<User> {
        delay(5000)
         val usersList: List<User> = listOf(
            User(1, "Shivam"),
            User(2, "Shashank"),
            User(3, "Ashi"),
            User(4, "Singh"),
        )
        return usersList
    }
}