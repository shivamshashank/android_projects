package com.example.coroutine2

import androidx.lifecycle.*
import com.example.coroutine2.model.User
import com.example.coroutine2.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
    private val userRepository: UserRepository = UserRepository()
//    var users: MutableLiveData<List<User>?> = MutableLiveData()

//    fun getUsers() {
//        viewModelScope.launch {
//            var result: List<User>? = null
//
//            withContext(Dispatchers.IO) {
//                result = userRepository.getUsers()
//            }
//
//            users.value = result
//        }
//    }

    var users: LiveData<List<User>> = liveData(Dispatchers.IO) {
        val result: List<User> = userRepository.getUsers()
        emit(result)
    }
}