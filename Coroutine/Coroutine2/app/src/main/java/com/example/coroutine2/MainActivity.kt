package com.example.coroutine2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.coroutine2.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
//        mainActivityViewModel.getUsers()

        mainActivityViewModel.users.observe(this, Observer { usersList ->
            usersList?.forEach {
                Log.i("MyTag", "name is ${it.name} && id is ${it.id}")
            }
        })

        CoroutineScope(Dispatchers.Main).launch {
            Log.i("MyTag", "calculation started...")

            val stocks1 = async(Dispatchers.IO) { getStocks1() }
            val stocks2 = async(Dispatchers.IO) { getStocks2() }

            val total = stocks1.await() + stocks2.await()

            Toast.makeText(this@MainActivity, "total $total stocks", Toast.LENGTH_LONG).show()
        }

        binding.apply {
            downloadUserDataButton.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
//                    userDataTextView.text = UserDataManager1().getUserId().toString()
                    userDataTextView.text = UserDataManager2().getUserId().toString()
                }
            }
        }
    }

    private suspend fun getStocks1(): Int {
        delay(10000)
        Log.i("MyTag", "stocks 1 returned")
        return 55000
    }

    private suspend fun getStocks2(): Int {
        delay(7000)
        Log.i("MyTag", "stocks 2 returned")
        return 35000
    }
}