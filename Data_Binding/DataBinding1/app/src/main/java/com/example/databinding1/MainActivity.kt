package com.example.databinding1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databinding1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private fun fetchStudent(): Student {
        return Student(0, "abc@xyz.com", "12345678")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            nameButton.setOnClickListener {
                "Hello ${editTextTextPersonName.text}!".also { nameTextView.text = it }
            }

            progressButton.setOnClickListener {
                if (progressBar.visibility == View.GONE) {
                    progressBar.visibility = View.VISIBLE
                    "STOP PROGRESS".also { progressButton.text = it }
                } else {
                    progressBar.visibility = View.GONE
                    "START PROGRESS".also { progressButton.text = it }
                }
            }

            student = fetchStudent()
        }
    }
}