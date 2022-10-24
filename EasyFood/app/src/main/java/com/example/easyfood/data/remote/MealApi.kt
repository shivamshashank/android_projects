package com.example.easyfood.data.remote

import com.example.easyfood.data.remote.dto.random_meal.RandomMealDto
import retrofit2.http.GET

interface MealApi {
    @GET("random.php")
    suspend fun getRandomMeal(): RandomMealDto
}