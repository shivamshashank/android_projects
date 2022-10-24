package com.example.easyfood.presentation.home.state

import com.example.easyfood.data.remote.dto.random_meal.RandomMealDto

sealed class RandomMealState {
    class Success(val randomMealDto: RandomMealDto? = null) : RandomMealState()
    class Failure(val errorText: String = "") : RandomMealState()
    object Loading : RandomMealState()
    object Empty : RandomMealState()
}