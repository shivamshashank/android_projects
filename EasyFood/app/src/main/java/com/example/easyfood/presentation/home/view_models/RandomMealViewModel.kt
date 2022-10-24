package com.example.easyfood.presentation.home.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easyfood.common.Resource
import com.example.easyfood.domain.use_case.get_random_meal.GetRandomMealUseCase
import com.example.easyfood.presentation.home.state.RandomMealState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RandomMealViewModel @Inject constructor(
    private val getRandomMealUseCase: GetRandomMealUseCase,
) : ViewModel() {

    private val _state = MutableLiveData<RandomMealState>(RandomMealState.Empty)
    val state: LiveData<RandomMealState> = _state

    fun getRandomMeal() {
        _state.value = RandomMealState.Loading

        getRandomMealUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = RandomMealState.Loading
                }
                is Resource.Success -> {
                    _state.value = RandomMealState.Success(result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        RandomMealState.Failure(result.message ?: "An unexpected error occurred!")
                }
            }
        }.launchIn(viewModelScope)
    }
}