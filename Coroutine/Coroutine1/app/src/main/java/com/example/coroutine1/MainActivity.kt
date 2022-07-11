package com.example.coroutine1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.coroutine1.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            Log.i("NewTag", "Hello from ${Thread.currentThread().name}")
        }

        CoroutineScope(Dispatchers.Main).launch {
            Log.i("NewTag", "Hello from ${Thread.currentThread().name}")
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            increaseCount.setOnClickListener {
                count++
                countTextView.text = count.toString()
            }

            downloadUserDataButton.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    downloadUserData(userDataTextView)
                }
            }
        }
    }

    private suspend fun downloadUserData(userDataTextView: TextView) {
        withContext(Dispatchers.Main) {
            for (i in 1..200000) {
                "Downloading user $i in ${Thread.currentThread().name}".also {
                    userDataTextView.text = it
                }
                delay(100)
            }
        }
    }

}