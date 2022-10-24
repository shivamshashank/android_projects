package com.example.easyfood.data.remote.dto.random_meal


import com.google.gson.annotations.SerializedName

data class RandomMealDto(
    @SerializedName("meals")
    val meals: List<Meal>
)