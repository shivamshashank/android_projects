package com.example.recyclerview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val fruitsList =
        listOf(
            Fruit("Mango", "Shivam"),
            Fruit("Apple", "Shashank"),
            Fruit("Banana", "Rahul"),
            Fruit("Guava", "Roy"),
            Fruit("Lemon", "Ashi"),
            Fruit("Pear", "Singh"),
            Fruit("Orange", "Yogesh"),
            Fruit("Mango", "Shivam"),
            Fruit("Apple", "Shashank"),
            Fruit("Banana", "Rahul"),
            Fruit("Guava", "Roy"),
            Fruit("Lemon", "Ashi"),
            Fruit("Pear", "Singh"),
            Fruit("Orange", "Yogesh"),
            Fruit("Mango", "Shivam"),
            Fruit("Apple", "Shashank"),
            Fruit("Banana", "Rahul"),
            Fruit("Guava", "Roy"),
            Fruit("Lemon", "Ashi"),
            Fruit("Pear", "Singh"),
            Fruit("Orange", "Yogesh"),
        )

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            myRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            myRecyclerView.adapter = MyRecyclerViewAdapter(fruitsList) { selectedFruit: Fruit ->
                showToastMessage(selectedFruit)
            }
        }
    }

    private fun showToastMessage(fruit: Fruit) {
        Toast.makeText(this, "Selected Fruit is ${fruit.name}", Toast.LENGTH_LONG).show()
    }
}