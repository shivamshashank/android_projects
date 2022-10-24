package com.example.easyfood.domain.use_case.get_random_meal

import com.example.easyfood.common.Resource
import com.example.easyfood.data.remote.dto.random_meal.RandomMealDto
import com.example.easyfood.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRandomMealUseCase @Inject constructor(
    private val mealRepository: MealRepository,
) {
    operator fun invoke(): Flow<Resource<RandomMealDto>> = flow {
        try {
            emit(Resource.Loading<RandomMealDto>())
            val randomMealDto = mealRepository.getRandomMeal()
            emit(Resource.Success<RandomMealDto>(randomMealDto))
        } catch (e: HttpException) {
            emit(Resource.Error<RandomMealDto>(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error<RandomMealDto>("You are offline!"))
        }
    }
}