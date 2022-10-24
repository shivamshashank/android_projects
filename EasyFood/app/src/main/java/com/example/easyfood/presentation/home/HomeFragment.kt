package com.example.easyfood.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.easyfood.R
import com.example.easyfood.databinding.FragmentHomeBinding
import com.example.easyfood.presentation.home.state.RandomMealState
import com.example.easyfood.presentation.home.view_models.RandomMealViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var viewModel: RandomMealViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[RandomMealViewModel::class.java]

        viewModel.getRandomMeal()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.apply {
            viewModel.state.observe(requireActivity()) {
                when (it) {
                    is RandomMealState.Loading -> {
                        randomMealProgressBar.visibility = View.VISIBLE
                    }
                    is RandomMealState.Success -> {
                        randomMealProgressBar.visibility = View.GONE

                        if (it.randomMealDto == null) {
                            randomMealFailure.visibility = View.VISIBLE
                            randomMealFailure.text = "Random Meal is Null"
                        } else {
                            if (it.randomMealDto.meals.isEmpty()) {
                                randomMealFailure.visibility = View.VISIBLE
                                randomMealFailure.text = "No Random Meal Present"
                            } else {
                                randomMealImage.visibility = View.VISIBLE

                                val imageUrl = it.randomMealDto.meals[0].strMealThumb

                                Glide.with(requireActivity())
                                    .load(imageUrl)
                                    .centerCrop()
                                    .placeholder(R.drawable.ic_cloud_download)
                                    .error(R.drawable.ic_broken_image)
                                    .into(binding.randomMealImage)
                            }
                        }
                    }
                    is RandomMealState.Failure -> {
                        randomMealProgressBar.visibility = View.GONE

                        randomMealFailure.visibility = View.VISIBLE
                        randomMealFailure.text = it.errorText
                    }
                    else -> {
                        randomMealProgressBar.visibility = View.GONE

                        randomMealFailure.visibility = View.VISIBLE
                        randomMealFailure.text = "Empty State"
                    }
                }
            }
        }

        return binding.root
    }
}