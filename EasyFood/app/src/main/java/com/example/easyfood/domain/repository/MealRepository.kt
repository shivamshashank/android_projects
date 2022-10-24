package com.example.easyfood.domain.repository

import com.example.easyfood.data.remote.dto.random_meal.RandomMealDto

interface MealRepository {
    suspend fun getRandomMeal(): RandomMealDto
}