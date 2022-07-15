package com.example.viewmodel1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingSummation: Int) : ViewModel() {
    private var count: MutableLiveData<Int> = MutableLiveData<Int>(0)
    private var summation: MutableLiveData<Int> = MutableLiveData<Int>()

    val countData: LiveData<Int>
        get() = count
    val summationData: LiveData<Int>
        get() = summation

    val summationText: MutableLiveData<String> = MutableLiveData<String>()

    init {
        summation.value = startingSummation
    }

    fun updateCount() {
        count.value = count.value?.plus(1)
    }

    fun updateSummation() {
        summation.value = summation.value?.plus(summationText.value!!.toIntOrNull() ?: 0)
    }
}