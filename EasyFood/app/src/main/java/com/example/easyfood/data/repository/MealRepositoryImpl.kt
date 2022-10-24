package com.example.easyfood.data.repository

import com.example.easyfood.data.remote.MealApi
import com.example.easyfood.data.remote.dto.random_meal.RandomMealDto
import com.example.easyfood.domain.repository.MealRepository
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val mealApi: MealApi,
) : MealRepository {
    override suspend fun getRandomMeal(): RandomMealDto {
        return mealApi.getRandomMeal()
    }
}